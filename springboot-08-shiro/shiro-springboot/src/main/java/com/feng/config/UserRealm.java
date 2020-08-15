package com.feng.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=》授权doGetAuthorizationInfo");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了=》验证doGetAuthenticationInfo");
        //用户名，密码数据中取
        String name = "root";
        String password = "123456";
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        if (!userToken.getUsername().equals(name)) {
            return null; //抛出异常UnknownAccountException
        }
        //密码认证。shiro 做~
        return new SimpleAuthenticationInfo("", password, "");
    }
}
