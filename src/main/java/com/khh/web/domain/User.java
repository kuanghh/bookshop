package com.khh.web.domain;

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
}