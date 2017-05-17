package com.khh.web.domain;

import com.khh.web.utils.CodeUtils;

import java.io.Serializable;

public class Person implements Serializable {
    private String id;

    private String account;

    private String email;

    private String phone;

    private String password;

    //默认为有效
    private boolean isValid = true;

    public Person(){
        this.id = CodeUtils.getUUID();
    }
    public Person(String password){
        this.password = password;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", isValid=" + isValid +
                '}';
    }
}