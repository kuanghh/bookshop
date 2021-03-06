package com.khh.common.bean;

import com.khh.web.domain.Goods;
import com.khh.web.utils.CodeUtils;
import com.khh.web.utils.MoneyConvert;

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

    //那个商家的
    private String shopId;

    private String shopName;

    private String shopAddress;

    private String categoryId;

    private String categoryName;

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public Goods vo2Domain(){
        Goods goods = new Goods();
        if(this.id != null) goods.setId(this.id);
        if(this.name != null) goods.setName(this.name);
        if(this.price != null) goods.setPrice(MoneyConvert.moneyStrToLong(price));
        if(this.promotinalPrice != null) goods.setPromotinalPrice(MoneyConvert.moneyStrToLong(promotinalPrice));
        if(this.num != 0) goods.setNum(num);
        if(this.description != null)goods.setDescription(this.description);
        if(this.createTime != null) goods.setCreateTime(this.createTime);
        if(this.pictures != null)goods.setPictures(this.pictures);
        if(this.postfree != null)goods.setPostfree(MoneyConvert.moneyStrToLong(this.postfree));
        if(this.shopId != null)goods.setShopId(this.shopId);
        if(this.categoryId != null)goods.setCategoryId(this.categoryId);
        return goods;
    }
}