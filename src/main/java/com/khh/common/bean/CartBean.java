package com.khh.common.bean;

import com.khh.web.domain.Cart;
import com.khh.web.utils.CodeUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/25.
 */
public class CartBean implements Serializable{

    private String id;

    //数目
    private Integer num;

    private String goodsId;

    private String userId;

    private String shopId;

    //产品名字
    private String goodsName;

    //产品价格
    private String goodsPrice;

    //邮费
    private String postfree;

    private String shopName;

    private String shopAddress;


    public CartBean(){
        this.id = CodeUtils.getUUID();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getPostfree() {
        return postfree;
    }

    public void setPostfree(String postfree) {
        this.postfree = postfree;
    }

    public Cart vo2Domain(){
        Cart cart = new Cart();
        if(this.id != null) cart.setId(this.id);
        if(this.num != null) cart.setNum(this.num);
        if(this.goodsId != null) cart.setGoodsId(this.goodsId);
        if(this.userId != null) cart.setUserId(this.userId);
        return cart;
    }
}
