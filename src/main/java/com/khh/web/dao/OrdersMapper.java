package com.khh.web.dao;

import com.khh.web.domain.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    /**
     * 批量增加订单
     * @param ordersList
     * @return
     */
    int insertAll(@Param("ordersList") List<Orders> ordersList);
}