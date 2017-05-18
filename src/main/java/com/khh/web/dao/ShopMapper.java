package com.khh.web.dao;

import com.khh.web.domain.Shop;
import com.khh.web.domain.User;

public interface ShopMapper {

    /**
     * 商家注册时添加新商家
     * @param shop
     * @return
     */
    int insert(Shop shop);
}