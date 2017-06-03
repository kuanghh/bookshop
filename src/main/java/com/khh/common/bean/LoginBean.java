package com.khh.common.bean;

import com.khh.common.constant_.Matches;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Created by 951087952@qq.com on 2017/5/16.
 * 登录用的bean
 */
public class LoginBean implements Serializable{
    private String account;

    private String email;

    private String phone;

    //密码
    @NotEmpty(message = "密码不能为空")
    @Pattern(regexp = Matches.PASSWORDPATTERN,message = "密码格式错误")
    private String password;

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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 判断当前bean是否有效
     * 仅当 accout == null && email == null && phone == null 为无效
     * @return
     */
    public boolean isEffective(){
        if(account == null && email == null && phone == null){
            return false;
        }
        return true;
    }

    /**
     * 获取当前用户登录的时候提交上来的账户，或者邮箱，或者密码
     * @return
     */
    public String getValidInfoToLogin(){
        if(account != null) return account;
        if(email != null) return email;
        if(phone != null) return phone;
        return null;
    }
}
