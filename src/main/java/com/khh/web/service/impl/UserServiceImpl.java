package com.khh.web.service.impl;

import com.khh.common.bean.UserRegisterBean;
import com.khh.web.dao.PersonMapper;
import com.khh.web.dao.PersonRoleMapper;
import com.khh.web.dao.RoleMapper;
import com.khh.web.dao.UserMapper;
import com.khh.web.domain.Person;
import com.khh.web.domain.PersonRole;
import com.khh.web.domain.Role;
import com.khh.web.domain.User;
import com.khh.web.security.RoleSign;
import com.khh.web.service.interface_.UserService;
import com.khh.web.utils.BeanUtilEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by 951087952@qq.com on 2017/5/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserMapper userMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private PersonMapper personMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private PersonRoleMapper personRoleMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int insert(UserRegisterBean registerBean) {
        //bean转domain
        Person person = (Person) BeanUtilEx.copyProperties2(new Person(), registerBean);
        User user = (User) BeanUtilEx.copyProperties2(new User(), registerBean);
        //设置注册
        user.setCreateTime(new Date());

        int first = personMapper.insert(person);
        int secound = userMapper.insert(user);

        /**赋予普通用户角色**/
        Role role = roleMapper.findBySign(RoleSign.SIMPLEUSER);
        int third = personRoleMapper.insert(new PersonRole(person.getId(),role.getId()));

        if(first == 1 && secound == 1 && third == 1){
            return 1;
        }
        return 0;
    }
}
