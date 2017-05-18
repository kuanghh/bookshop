package com.khh.common.bean;

import com.khh.web.utils.CodeUtils;
import org.hibernate.validator.constraints.NotEmpty;

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
    @NotEmpty
    private String account;

    //用户邮件
    @NotEmpty
    private String email;

    //用户电话
    @NotEmpty
    private String phone;

    //用户登录密码
    @NotEmpty
    private String password;

    //用户出生时间
    private String birthday;

    private Date createTime;


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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
