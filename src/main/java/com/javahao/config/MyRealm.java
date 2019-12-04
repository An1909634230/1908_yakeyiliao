package com.javahao.config;

import com.javahao.pojo.DocterShiro;
import com.javahao.pojo.TbSysPermission;
import com.javahao.service.SysDoctroService;
import com.javahao.service.SysPermissionService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by 54110 on 2019/11/22.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private SysDoctroService sds;
    @Autowired
    private SysPermissionService sysPermissionService;

    //权限的
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        //登录名称查询该用户的权限
        List<TbSysPermission> userPermissionByUserName = sysPermissionService.findUserPermissionByUserName(primaryPrincipal);
        if (userPermissionByUserName != null && userPermissionByUserName.size() > 0) {
            //去重
            Collection list = new HashSet<>();
            for (TbSysPermission per : userPermissionByUserName
                    ) {
                list.add(per.getPerName());
            }

            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addStringPermissions(list);
            return simpleAuthorizationInfo;
        }


        return null;

    }

    //登录的
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取到当前登录的用户名
        String username = (String) authenticationToken.getPrincipal();
        //通过用户名去数据库查询正确的密码
        DocterShiro user = sds.findByDoctorName(username);
        if (user != null) {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getDname(), user.getPassword(), getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }


}