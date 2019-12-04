package com.javahao.dao;

import com.javahao.pojo.DocterShiro;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/4.
 */
@Mapper
public interface SysDocter {
   public DocterShiro findByDoctorName(String username);
   @Select("select * from doctor")
   public List<DocterShiro>findAll();

}
