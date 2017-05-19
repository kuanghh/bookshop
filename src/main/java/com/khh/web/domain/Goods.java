package com.khh.web.domain;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable{

    //唯一标识
    private String id;
    //书本名称
    private String name;
    //书本价格
    private Double price;
    //促销价格
    private Double promotinalPrice;
    //库存
    private Integer num;
    //描述
    private String description;
    //上架时间
    private Date createTime;
    //图片地址
    private String pictures;
    //邮费
    private Double postfree;

    //是否已经下架
    private Integer state;

    //那个商家的
    private String shopId;

    private boolean isValid;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPromotinalPrice() {
        return promotinalPrice;
    }

    public void setPromotinalPrice(Double promotinalPrice) {
        this.promotinalPrice = promotinalPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
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

    public Double getPostfree() {
        return postfree;
    }

    public void setPostfree(Double postfree) {
        this.postfree = postfree;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
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
}