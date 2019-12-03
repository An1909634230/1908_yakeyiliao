package com.javahao.dao;

import com.javahao.pojo.LunBo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/2.
 */
@Mapper
public interface LunBoDao {
    @Select("select * from lunbo")
    public List<LunBo> finAll();



}
