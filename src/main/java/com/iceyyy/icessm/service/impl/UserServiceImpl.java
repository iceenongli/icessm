package com.iceyyy.icessm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iceyyy.icessm.dao.UserMapper;
import com.iceyyy.icessm.pojo.User;
import com.iceyyy.icessm.service.UserService;

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
        return userMapper.findAll();
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
}
