package com.iceyyy.icessm.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.iceyyy.icessm.pojo.User;

public interface UserService {
    void add(User user);

    User getById(Integer userId);

    List<User> getAll();

    int deleteBatch(String[] ids);

	PageInfo<User> pageUser(Page<User> page, User user);

	User getUserById(Integer userId);

	void saveUser(User user);

	void updateUserBatch(User user, String ids);
}
