package com.khh.web.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Goods implements Serializable{

    //唯一标识
    private String id;
    //书本名称
    private String name;
    //书本价格(分)
    private long price;
    //促销价格(分)
    private long promotinalPrice;
    //库存
    private int num;
    //描述
    private String description;
    //上架时间
    private Date createTime;
    //图片地址(json数组)
    private String pictures;
    //邮费(分)
    private long postfree;

    //是否已经下架 (默认已经上架)
    private int state = STATE_VALID;

    //哪个商家的id
    private String shopId;

    private String categoryId;


    private Category category;

    private Shop shop;

    
    //默认有效
    private boolean isValid = true;

    public final static int STATE_VALID = 1;  //已上架
    public final static int STATE_NOVALID = 0; //未上架



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures == null ? null : pictures.trim();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPromotinalPrice() {
        return promotinalPrice;
    }

    public void setPromotinalPrice(long promotinalPrice) {
        this.promotinalPrice = promotinalPrice;
    }

    public long getPostfree() {
        return postfree;
    }

    public void setPostfree(long postfree) {
        this.postfree = postfree;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}