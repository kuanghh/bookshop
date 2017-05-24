package com.khh.web.dao;

import com.khh.common.bean.GoodsBean;
import com.khh.common.bean.PagerBean;
import com.khh.web.domain.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Goods record);


    /**
     *根据指定条件获取一共有多少条商品记录,商家是否需要认证(只查询有效记录)
     * @param
     * @return
     */
    int findCountWithKeyAndShopId(@Param("goods") Goods goods,@Param("shopAuth") boolean shopAuth);

    /**
     * 根据指定条件获取所有商品记录，商家是否需要认证(只查询有效记录)(默认按时间排序)
     * @param
     * @param
     * @return
     */
    List<Goods> findBeanInPageWithKeyAndShopId(@Param("start") int start,@Param("size") int size ,@Param("g")Goods goods,@Param("shopAuth")boolean shopAuth);

    /**
     * 根据id删除商品（假删除）
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 根据id查询商品(只查询有效记录)
     * @param id
     * @return
     */
    Goods findById(String id);

    /**
     * 根据id修改商品状态(只修改有效记录)
     * @param id
     * @param state
     * @return
     */
    int updateState(@Param("id") String id,@Param("state") int state);
}