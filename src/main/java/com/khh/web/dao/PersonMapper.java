package com.khh.web.dao;

import com.khh.web.domain.Person;
import org.apache.ibatis.annotations.Param;

public interface PersonMapper {

    /**
     * 添加新成员
     * @param person
     * @return
     */
    int insert(Person person);

    /**
     * 根据Id删除  这里是假删除
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 更新成员
     * @param person
     * @return
     */
    int update(Person person);


    /**
     * 通过  邮箱-密码 或 帐号-密码 或  电话号码-密码 进行查询登录（只查询有效信息）
     * @param person
     * @return
     */
    Person findForLogin(Person person);

    /**
     * 通过邮件查询用户（只查询有效信息）
     * @param email
     * @return
     */
    Person findByEmail(String email);

    /**
     * 通过帐号查询用户（只查询有效信息）
     * @param account
     * @return
     */
    Person findByAccount(String account);

    /**
     * 通过手机号码查询用户（只查询有效信息）
     * @param phone
     * @return
     */
    Person findByPhone(String phone);


}