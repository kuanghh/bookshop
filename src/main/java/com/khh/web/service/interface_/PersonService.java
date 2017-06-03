package com.khh.web.service.interface_;

import com.khh.common.bean.UserRegisterBean;
import com.khh.web.domain.Person;

/**
 * Created by 951087952@qq.com on 2017/5/15.
 */
public interface PersonService {

    /**
     * 增加新成员
     * @param person
     * @return
     */
    int insert(Person person);

    /**
     * 通过  邮箱-密码 或 帐号-密码 或  电话号码-密码 进行查询登录
     * @param person
     * @return
     */
    Person findForLogin(Person person);

    /**
     * 通过邮件查询用户
     * @param email
     * @return
     */
    Person findByEmail(String email);

    /**
     * 通过帐号查询用户
     * @param account
     * @return
     */
    Person findByAccount(String account);

    /**
     * 通过手机号码查询用户
     * @param phone
     * @return
     */
    Person findByPhone(String phone);

    /**
     * 根据id还有密码查询用户
     * @param id
     * @param password
     * @return
     */
    int findByIdAndPassword(String id, String password);

    /**
     * 检测注册时帐号，邮箱，电话重复的问题
     * @param account
     * @param email
     * @param phone
     * @return  返回验证信息，当返回null的时候，证明没有重复
     */
    String findForCheckRegisterRepeatInfo(String account,String email,String phone);

}
