package com.khh.web.dao;

import com.khh.web.domain.Person;

public interface PersonMapper {

    /**
     * 添加新成员
     * @param person
     * @return
     */
    int insert(Person person);

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
}