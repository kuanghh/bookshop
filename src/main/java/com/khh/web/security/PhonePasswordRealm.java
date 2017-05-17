package com.khh.web.security;


import com.khh.common.constant_.PersonLogin;
import com.khh.web.domain.Permission;
import com.khh.web.domain.Person;
import com.khh.web.domain.Role;
import com.khh.web.service.interface_.PermissionService;
import com.khh.web.service.interface_.PersonService;
import com.khh.web.service.interface_.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by 951087952@qq.com on 2017/4/17.
 * 手机号码-密码 认证管理器
 */
public class PhonePasswordRealm extends AuthorizingRealm {

    @Autowired
    private PersonService personService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public String getName() {
        return "PhoneSecurityRealm";
    }

    //支持什么类型的token
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 权限检查
     * @param principal
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String phone = (String) principal.getPrimaryPrincipal();
        try{
            final Person person = personService.findByPhone(phone);
            //找到所有角色
            List<Role> list = roleService.findAllByPersonId(person.getId());
            Stream<String> rSignstream = list.stream().map(Role::getSign);
            authorizationInfo.addRoles(rSignstream.collect(Collectors.toList()));
            //找到所有权限
            Stream<String> pSignstream = list.stream().flatMap(r -> {
                List<Permission> pl = permissionService.findAllByRoleId(r.getId());
                return pl.stream().map(Permission::getSign);
            });
            authorizationInfo.addStringPermissions(pSignstream.collect(Collectors.toList()));
        }catch (Exception e){
        }
        return authorizationInfo;
    }

    /**
     * 登录验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String phone = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials());
        //通过数据库进行验证
        Person p = new Person(password);
        p.setPhone(phone);
        final Person person = personService.findForLogin(p);
        if(person == null){
            throw new AuthenticationException("电话或密码错误");
        }
        PersonLogin.set(person);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(phone,password,getName());
        return authenticationInfo;
    }
}
