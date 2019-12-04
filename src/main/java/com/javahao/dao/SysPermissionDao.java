package com.javahao.dao;


import com.javahao.pojo.TbSysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 54110 on 2019/11/22.
 */
@Mapper
public interface SysPermissionDao {
    List<TbSysPermission> findUserPermissionByUserName(String name);
}
