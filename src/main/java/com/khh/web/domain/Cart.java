package com.khh.web.domain;

import com.khh.common.bean.CartBean;
import com.khh.web.utils.CodeUtils;
import com.khh.web.utils.MoneyConvert;

import java.io.Serializable;
import java.util.Date;

public class Cart implements Serializable{

    private String id;

    //最后更新时间
    private Date updateTime;

    //数目
    private Integer num;

    private String goodsId;

    private String userId;

    private Goods goods;

    //默认有效
    private boolean isValid = true;

    public Cart(){
        this.id = CodeUtils.getUUID();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public CartBean domain2Vo(){
        CartBean cartBean = new CartBean();
        if(this.id != null) cartBean.setId(this.id);
        if(this.num != null) cartBean.setNum(this.num);
        if(this.goodsId != null) cartBean.setGoodsId(this.goodsId);
        if(this.userId != null) cartBean.setUserId(this.userId);

        if(this.goods != null){
            cartBean.setGoodsName(this.getGoods().getName());
            cartBean.setGoodsPrice(MoneyConvert.moneyLongToStr(this.getGoods().getPrice()));
            cartBean.setPostfree(MoneyConvert.moneyLongToStr(this.getGoods().getPostfree()));
            Shop shop = this.goods.getShop();
            if(shop != null){
                cartBean.setShopId(shop.getId());
                cartBean.setShopName(shop.getShopName());
                cartBean.setShopAddress(shop.getAddress());
            }
        }
        return cartBean;
    }
}