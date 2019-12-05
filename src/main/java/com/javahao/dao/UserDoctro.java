package com.javahao.dao;

import com.javahao.pojo.UserHou;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/5.
 */
@Mapper
public interface UserDoctro {
    public List<UserHou> selectLike(String dname);
    @Select("select count(*) from user")
    public int selectCount();
}
