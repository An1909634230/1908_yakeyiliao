package com.javahao.service;

import com.javahao.pojo.Pay;
import com.javahao.pojo.User;
import org.springframework.web.bind.annotation.RequestBody;

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
    void SendSimpleMail(String to,String number,String name);
    //充值
    int memberMoney(User user);
    //查询余额
    Double inquire(String member);
    //查询会员是否存在
    String findByMember(String member);
}
