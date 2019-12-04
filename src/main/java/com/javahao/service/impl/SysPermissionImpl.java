package com.javahao.service.impl;

import com.javahao.dao.SysPermissionDao;
import com.javahao.pojo.TbSysPermission;
import com.javahao.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 54110 on 2019/11/22.
 */
@Service
public class SysPermissionImpl implements SysPermissionService {

    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Override
    public List<TbSysPermission> findUserPermissionByUserName(String name) {
        return sysPermissionDao.findUserPermissionByUserName(name);
    }
}
