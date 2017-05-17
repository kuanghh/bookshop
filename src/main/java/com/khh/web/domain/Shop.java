package com.khh.web.domain;

import java.io.Serializable;
import java.util.Date;

public class Shop extends Person implements Serializable {

    private String shopName;

    private String ownName;

    private String ownIdCard;

    private String address;

    private Date createTime;

    private Date authenticationTime;

    private int state;

    public Shop(){super();}


    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getOwnName() {
        return ownName;
    }

    public void setOwnName(String ownName) {
        this.ownName = ownName == null ? null : ownName.trim();
    }

    public String getOwnIdCard() {
        return ownIdCard;
    }

    public void setOwnIdCard(String ownIdCard) {
        this.ownIdCard = ownIdCard == null ? null : ownIdCard.trim();
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

    public Date getAuthenticationTime() {
        return authenticationTime;
    }

    public void setAuthenticationTime(Date authenticationTime) {
        this.authenticationTime = authenticationTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}