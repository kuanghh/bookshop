package com.khh.web.dao;

import com.khh.web.domain.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    Cart findByGoodIdAndUserId(@Param("goodsId") String goodsId,@Param("userId") String userId);


    /**
     * 根据用户id查询所有购物车记录
     * @param id
     * @return
     */
    List<Cart> findAllByUserId(@Param("userId") String id);
}