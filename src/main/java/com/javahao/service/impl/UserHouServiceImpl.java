package com.javahao.service.impl;

import com.javahao.pojo.UserHou;
import com.javahao.responsitory.UserHouResponsitory;
import com.javahao.service.UserHouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/4.
 */
@Service
public class UserHouServiceImpl implements UserHouService {
    @Autowired
    private UserHouResponsitory ur;

    @Override
    public List<UserHou> findAll() {
        return ur.findAll();
    }

    @Override
    public void add(UserHou userHou) {
        ur.save(userHou);
    }

    @Override
    public void deleteUserHou(Integer uid) {
        ur.deleteById(uid);
    }

    @Override
    public UserHou findUserHouByUid(Integer uid) {
        return ur.findUserHouByuid(uid);
    }

    @Override
    public void updateUserHou(UserHou userHou) {
        ur.saveAndFlush(userHou);
    }
}
