package com.javahao.dao;

import com.javahao.pojo.Ser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/3.
 */
@Mapper
public interface SerDao {
    @Select("select * from service")
    public List<Ser>findAll();
}
