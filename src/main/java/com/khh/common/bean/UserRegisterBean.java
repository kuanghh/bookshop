package com.khh.common.bean;

import com.khh.web.utils.CodeUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 951087952@qq.com on 2017/5/17.
 * 普通用户注册bean
 */
public class UserRegisterBean implements Serializable{

    //唯一标识
    private String id ;

    //用户名字
    private String name;

    //用户帐号
    private String account;

    //用户邮件
    private String email;

    //用户电话
    private String phone;

    //用户登录密码
    private String password;

    //用户出生时间
    private Date birthday;

    public UserRegisterBean(){this.id = CodeUtils.getUUID();}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
