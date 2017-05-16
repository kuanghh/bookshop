package com.khh.web.service.interface_;

import com.khh.web.domain.Person;

/**
 * Created by 951087952@qq.com on 2017/5/15.
 */
public interface PersonService {

    /**
     * 通过  邮箱-密码 或 帐号-密码 或  电话号码-密码 进行查询登录
     * @param person
     * @return
     */
    Person findForLogin(Person person);
}
