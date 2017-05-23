package com.khh.web.dao;

import com.khh.common.bean.GoodsBean;
import com.khh.common.bean.PagerBean;
import com.khh.web.domain.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Goods record);


    /**
     *根据关键字，商铺id，获取一共有多少条商品记录(只查询有效记录)
     * @param keyMap
     * @return
     */
    int findCountWithKeyAndShopId(Map<String, String> keyMap,String shopId);

    /**
     * 根据关键字，商铺id，获取所有商品记录(只查询有效记录)
     * @param pagerBean
     * @param shopId
     * @return
     */
    List<GoodsBean> findBeanInPageWithKeyAndShopId(PagerBean<GoodsBean> pagerBean, String shopId);
}