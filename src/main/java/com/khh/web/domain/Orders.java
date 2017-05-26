package com.khh.web.domain;

import com.khh.web.utils.CodeUtils;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable{
    private String id;

    //订单编号
    private String serial;

    private Date createTime;

    //商品个数
    private Integer num;

    private Long totalPrice;

    private String goodsId;

    private String shopId;

    private String userId;

    private String address;

    //状态 1:表示发货  0:表示未发货
    private Integer state;

    //默认有效
    private boolean isValid = true;

    public static final int ORDERS_NOTSEND = 0;
    public static final int ORDERS_SEND = 1;

    public Orders(){
        this.id = CodeUtils.getUUID();
        this.serial = CodeUtils.getOrderSerial();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
}