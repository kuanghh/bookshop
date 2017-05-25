package com.khh.web.domain;

import com.khh.common.bean.UserBean;
import com.khh.common.bean.UserRegisterBean;
import com.khh.web.utils.DateTool;

import java.io.Serializable;
import java.util.Date;

public class User extends Person implements Serializable{

    private String name;

    private Date birthday;

    private String address;

    private Date createTime;

    public User(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public UserBean domain2Vo(){
        UserBean userBean = new UserBean();

        if(this.getId() != null) userBean.setId(this.getId());
        if(this.getAccount() != null) userBean.setAccount(this.getAccount());
        if(this.getEmail() != null) userBean.setEmail(this.getEmail());
        if(this.getPhone() != null) userBean.setPhone(this.getPhone());

        if(this.birthday != null) userBean.setBirthday(DateTool.Date2Str(this.birthday));
        if(this.name != null) userBean.setName(this.name);
        if(this.address != null) userBean.setAddress(this.address);
        if(this.createTime != null) userBean.setCreateTime(this.createTime);
        return userBean;
    }
}