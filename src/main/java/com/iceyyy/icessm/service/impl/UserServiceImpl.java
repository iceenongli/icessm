package com.iceyyy.icessm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iceyyy.icessm.dao.UserMapper;
import com.iceyyy.icessm.pojo.User;
import com.iceyyy.icessm.service.UserService;

import cn.hutool.core.text.StrSpliter;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public void add(User user) {
        userMapper.insert(user);
    }

    public User getById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public List<User> getAll() {
//        return userMapper.findAll();
    	return null;
    }

    public int deleteBatch(String[] ids) {
        Integer[] idsInt = idsInt(ids);
        return userMapper.deleteBatch(idsInt);
    }

    private Integer[] idsInt(String[] ids) {
        Integer[] nums = new Integer[ids.length];
        for (int i = 0; i < ids.length; i++) {
            nums[i] = Integer.parseInt(ids[i]);
        }
        return nums;
    }

	@Override
	public PageInfo<User> pageUser(Page<User> page, User user) {
		Integer pageNum = page.getPageNum();
		Integer pageSize = page.getPageSize();
    	PageHelper.startPage(pageNum, pageSize);
    	List<User> userList = userMapper.pageUser(user);
    	PageInfo<User> pageInfo = new PageInfo<User>(userList);
    	return pageInfo;
	}

	@Override
	public User getUserById(Integer userId) {
		return userMapper.getUserById(userId);
	}

	@Override
	public void saveUser(User user) {
		userMapper.insertSelective(user);
	}

	@Override
	public void updateUserBatch(User user, String ids) {
		List<String> idList = StrSpliter.split(ids, ",", true, true);
		userMapper.updateUserBatch(user, idList);
	}
}
