package com.khh.test;

import com.khh.web.domain.*;
import com.khh.web.security.PermissionSign;
import com.khh.web.security.RoleSign;
import com.khh.web.service.interface_.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;

/**
 * Created by 951087952@qq.com on 2017/4/18.
 * 为系统弄一个管理员
 */
public class InitUtils {


    public static void main(String[] args) {

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
//        PersonService personService = (PersonService) context.getBean("personService");
//        Person person = new Person("123456");
//        person.setAccount("haohua");
//        Person p = personService.findForLogin(person);
//        System.out.println(p.toString());

//        initPermission();
//        initRole();
//        initUser();
    }

//    public static void initUser(){
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
//        PersonService personService = (PersonService) context.getBean("personService");
//        Person person = new Person();
//        person.setAccount("haohua");
//        person.setEmail("951087952@qq.com");
//        person.setPassword("123456");
//        person.setPhone("18927766631");
//        person.setIsValid(true);
//        personService.insert(person);
//
//        PersonRoleService personRoleService =  (PersonRoleService)context.getBean("personRoleService");
//        PersonRole personRole = new PersonRole();
//        personRole.setPersonId(person.getId());
//        personRole.setRoleId("32c308652cf048c3b9dd800ec791f3e7");
//        personRole.setIsValid(true);
//
//        personRoleService.insert(personRole);
//    }
//
//    public static void initRole(){
//
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
//        RoleService roleService = (RoleService) context.getBean("roleService");
//        Role role = new Role();
//        role.setName("普通用户");
//        role.setDescription("拥有所有普通用户权限");
//        role.setSign(RoleSign.SIMPLEUSER);
//        role.setIsValid(true);
//        roleService.insert(role);
//
//        Role role2 = new Role();
//        role2.setName("店铺商家");
//        role2.setDescription("拥有所有商家权限");
//        role2.setSign(RoleSign.SHOP);
//        role2.setIsValid(true);
//        roleService.insert(role2);
//
//        RolePermissionService rolePermissionService = (RolePermissionService) context.getBean("rolePermissionService");
//
//
//        RolePermission rp2 = new RolePermission();
//        rp2.setIsValid(true);
//        rp2.setRoleId(role2.getId());
//        rp2.setPermissionId("6b4241b59c3c40f8a088c65f6230108d");
//
//        RolePermission rp3 = new RolePermission();
//        rp3.setIsValid(true);
//        rp3.setRoleId(role.getId());
//        rp3.setPermissionId("849228fe9c1f4e0887fb4720e14d1ad0");
//
//        rolePermissionService.insert(rp2);
//        rolePermissionService.insert(rp3);
//
//    }
//
//
//    public static void initPermission(){
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
//        PermissionService permissionService = (PermissionService) context.getBean("permissionService");
//
//        Map<String, Object> permisssionMap = PermissionSign.PERMISSSION_MAP;
//
//        Set<Map.Entry<String, Object>> entries = permisssionMap.entrySet();
//        for(Map.Entry<String, Object> kv :entries){
//            Permission permission = new Permission();
//            permission.setName(kv.getKey());
//            permission.setDescription(kv.getKey());
//            permission.setSign((String) kv.getValue());
//            permission.setIsValid(true);
//            permissionService.insert(permission);
//        }
//    }

}
