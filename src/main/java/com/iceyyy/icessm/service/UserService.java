package com.iceyyy.icessm.service;

import java.util.List;

import com.iceyyy.icessm.pojo.User;

public interface UserService {
    void add(User user);

    User getById(Integer userId);

    List<User> getAll();

    int deleteBatch(String[] ids);
}
