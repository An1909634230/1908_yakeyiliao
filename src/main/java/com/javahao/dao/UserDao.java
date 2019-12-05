package com.javahao.dao;

import com.javahao.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/2.
 */
@Mapper
public interface UserDao {
    List<User> selectAll();
    void delete(Integer id);
    void insert(User user);
    User findById(Integer id);
    void update(User user);
    //充值
    int memberMoney(User user);
    //查询余额
    Double inquire(String member);
    //查询会员名是否存在
    String findByMember(String member);
}
