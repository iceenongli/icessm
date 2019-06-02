package com.iceyyy.icessm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iceyyy.icessm.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int deleteBatch(Integer[] ids);

	List<User> pageUser(User user);

	User getUserById(Integer userId);

	void saveUser(User user);

	void updateUserBatch(@Param("user")User user, @Param("ids") List<String> ids);
}