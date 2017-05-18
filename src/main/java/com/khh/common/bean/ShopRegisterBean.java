package com.khh.common.bean;

import com.khh.web.utils.CodeUtils;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Administrator on 2017/5/18.
 */
public class ShopRegisterBean {

    //唯一标识
    private String id ;

    //店铺名字
    @NotEmpty
    private String shopName;

    //店铺拥有者的名字
    @NotEmpty
    private String ownName;

    //店铺拥有者的身份证号
    @NotEmpty
    private String ownIdCard;

    //店铺具体地址
    @NotEmpty
    private String address;

    //商家帐号
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


    public ShopRegisterBean(){this.id = CodeUtils.getUUID();}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getOwnName() {
        return ownName;
    }

    public void setOwnName(String ownName) {
        this.ownName = ownName;
    }

    public String getOwnIdCard() {
        return ownIdCard;
    }

    public void setOwnIdCard(String ownIdCard) {
        this.ownIdCard = ownIdCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
