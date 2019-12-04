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
    User selectByNameAndPass(String uname,String upass);
    void delete(Integer id);
    void insert(User user);
    User findById(Integer id);
    void update(User user);
}
