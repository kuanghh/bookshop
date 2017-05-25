package com.khh.web.dao;

import com.khh.web.domain.Cart;
import org.apache.ibatis.annotations.Param;

public interface CartMapper {
    int deleteByPrimaryKey(String id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    /**
     * 根据商品id和用户id查询行数(只查询有效记录)
     * @param goodsId
     * @param userId
     * @return
     */
    int findByGoodIdAndUserId(@Param("goodsId") String goodsId,@Param("userId") String userId);

    /**
     * 根据商品id和用户id，更新商品记录数
     * @param cart
     * @return
     */
    int updateByGoodsIdAndUserId(Cart cart);
}