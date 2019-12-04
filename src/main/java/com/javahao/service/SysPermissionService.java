package com.javahao.service;

import com.javahao.pojo.TbSysPermission;

import java.util.List;

/**
 * Created by anzIhao on 2019/11/28.
 */

public interface SysPermissionService {
    public List<TbSysPermission> findUserPermissionByUserName(String name);
}
