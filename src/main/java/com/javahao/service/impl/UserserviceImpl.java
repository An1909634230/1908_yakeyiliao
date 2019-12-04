package com.javahao.service.impl;

import com.javahao.dao.UserDao;
import com.javahao.pojo.User;
import com.javahao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/2.
 */
@Service
public class UserserviceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public User selectByNameAndPass(String uname, String upass) {
        return userDao.selectByNameAndPass(uname,upass);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }
}
