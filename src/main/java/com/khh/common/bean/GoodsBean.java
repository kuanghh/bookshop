package com.khh.common.bean;

import com.khh.web.domain.Goods;
import com.khh.web.utils.CodeUtils;

import java.io.Serializable;
import java.util.Date;

public class GoodsBean implements Serializable{

    //唯一标识
    private String id;
    //书本名称
    private String name;
    //书本价格
    private String price;
    //促销价格
    private String promotinalPrice;
    //库存
    private int num;
    //描述
    private String description;
    //上架时间
    private Date createTime;
    //图片地址
    private String pictures;
    //邮费
    private String postfree;

    //是否已经下架(默认为上架)
    private int state = Goods.STATE_VALID;

    private String categoryId;

    //那个商家的
    private String shopId;

    public GoodsBean(){
        this.id = CodeUtils.getUUID();
    }

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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPromotinalPrice() {
        return promotinalPrice;
    }

    public void setPromotinalPrice(String promotinalPrice) {
        this.promotinalPrice = promotinalPrice;
    }

    public String getPostfree() {
        return postfree;
    }

    public void setPostfree(String postfree) {
        this.postfree = postfree;
    }
}