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
     *根据关键字，商铺id，获取一共有多少条商品记录(只查询有效记录)
     * @param
     * @return
     */
    int findCountWithKeyAndShopId(@Param("g") Goods goods);

    /**
     * 根据商品名称，类别id，商铺id，获取所有商品记录(只查询有效记录)(默认按时间排序)
     * @param
     * @param
     * @return
     */
    List<Goods> findBeanInPageWithKeyAndShopId(@Param("start") int start,@Param("size") int size ,@Param("g")Goods goods);

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