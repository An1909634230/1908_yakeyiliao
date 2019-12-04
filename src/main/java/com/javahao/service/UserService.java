package com.javahao.service;

import com.javahao.pojo.User;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/2.
 */
public interface UserService {
    List<User> selectAll();

    void delete(Integer id);
    void insert(User user);
    User findById(Integer id);
    void update(User user);
    void SendSimpleMail(String to);
}
