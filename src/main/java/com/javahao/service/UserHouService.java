package com.javahao.service;

import com.javahao.pojo.Ser;
import com.javahao.pojo.UserHou;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/4.
 */
public interface UserHouService {
    public List<UserHou> findAll();

    public void add(UserHou userHou);

    public void deleteUserHou(Integer uid);

    public UserHou findUserHouByUid(Integer uid);

    public void updateUserHou(UserHou userHou);
}
