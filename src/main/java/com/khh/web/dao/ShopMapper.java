package com.khh.web.dao;

import com.khh.common.bean.PagerBean;
import com.khh.common.bean.ShopRegisterBean;
import com.khh.common.bean.UserRegisterBean;
import com.khh.web.domain.Shop;
import com.khh.web.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShopMapper {

    /**
     * 商家注册时添加新商家
     * @param shop
     * @return
     */
    int insert(Shop shop);

    /**
     * 更新用户
     */
    int update(Shop shop);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     *
     * @param keyMap
     * @return
     */
    int findCountWithKey(@Param("keyMap")Map<String, String> keyMap);

    /**
     *
     * @param pagerBean
     * @return
     */
    List<ShopRegisterBean> findBeanInPage(PagerBean<ShopRegisterBean> pagerBean);



}