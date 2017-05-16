package com.khh.web.utils;


import com.khh.web.domain.Person;
import com.khh.web.service.interface_.PersonService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 951087952@qq.com on 2017/4/18.
 * 为系统弄一个管理员
 */
public class InitUtils {


    public static void main(String[] args) {
//        System.out.println(System.getProperty("java.io.tmpdir"));//C:\Users\ADMINI~1.PC-\AppData\Local\Temp\

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        PersonService personService = (PersonService) context.getBean("personService");
        Person person = new Person("123456");
        person.setAccount("haohua");
        Person p = personService.findForLogin(person);
        System.out.println(p.toString());
    }
//
//    public static void initUser(){
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
//        UserService userService = (UserService) context.getBean("userService");
//        User user = new User();
//        user.setName("haohua");
//        user.setEmail("951087952@qq.com");
//        user.setPassword("123456");
//        user.setState(User.USER_STATE_ENABLE);
//        user.setCreateTime(new Date());
//        user.setIsValid(true);
//        userService.insert(user);
//
//        RoleService roleService = (RoleService) context.getBean("roleService");
//        UserRoleService userRoleService =  (UserRoleService)context.getBean("userRoleService");
//        List<Role> roleList = roleService.findAll();
//
//        for (int i = 0; i < roleList.size(); i++) {
//            Role role = roleList.get(i);
//            UserRole userRole = new UserRole();
//            userRole.setUserId(user.getId());
//            userRole.setRoleId(role.getId());
//            userRole.setIsValid(true);
//            userRoleService.insert(userRole);
//        }
//
//    }
//
//    public static void initRole(){
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
//        RoleService roleService = (RoleService) context.getBean("roleService");
//        Role role = new Role();
//        role.setName("超级管理员");
//        role.setDescription("拥有所有权限");
//        role.setSign(RoleSign.SYSTEMADMIN);
//        role.setIsValid(true);
//        roleService.insert(role);
//
//        RolePermissionService rolePermissionService = (RolePermissionService) context.getBean("rolePermissionService");
//        PermissionService permissionService = (PermissionService) context.getBean("permissionService");
//        List<Permission> list = permissionService.findAll();
//
//        for (int i = 0; i < list.size(); i++) {
//            Permission permission = list.get(i);
//            RolePermission rolePermission = new RolePermission();
//            rolePermission.setIsValid(true);
//            rolePermission.setRoleId(role.getId());
//            rolePermission.setPermissionId(permission.getId());
//            rolePermissionService.insert(rolePermission);
//        }
//
//    }


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
//            permission.setIdValid(true);
//            permissionService.insert(permission);
//        }
//    }

}
