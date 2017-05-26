package com.khh.common.bean;

import com.khh.web.domain.Orders;
import com.khh.web.utils.CodeUtils;
import com.khh.web.utils.MoneyConvert;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/26.
 */
public class OrdersBean implements Serializable{

    private String id;

    private String serial;

    private Date createTime;

    private Integer num;

    private String totalPrice;

    private String goodsId;

    private String shopId;

    private String userId;

    private String address;

    private Integer state;


    private String shopName;

    private String goodsName;




    public OrdersBean(){
        this.id = CodeUtils.getUUID();
        this.serial = CodeUtils.getOrderSerial();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
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

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Orders vo2Domain(){
        Orders orders = new Orders();

        if(this.id != null) orders.setId(this.id);
        if(this.serial != null) orders.setSerial(this.serial);
        if(this.createTime != null) orders.setCreateTime(this.createTime);
        if(this.num != null) orders.setNum(this.num);
        if(this.totalPrice != null) orders.setTotalPrice(MoneyConvert.moneyStrToLong(this.totalPrice));
        if(this.goodsId != null) orders.setGoodsId(this.goodsId);
        if(this.shopId != null) orders.setShopId(this.shopId);
        if(this.userId != null) orders.setUserId(this.userId);
        if(this.address != null) orders.setAddress(this.address);
        if(this.state != null) orders.setState(this.state);

        return orders;
    }
}
