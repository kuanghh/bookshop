package com.khh.web.dao;

import com.khh.common.bean.OrdersBean;
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


    /**
     * 带条件查询记录条数
     * @param o
     * @return
     */
    int findCountWithKey(@Param("orders") Orders o);

    /**
     * 带条件分页查询记录
     * @param start
     * @param size
     * @param o
     * @return
     */
    List<Orders> findBeanInPage(@Param("start") int start,@Param("size") Integer size,@Param("orders") Orders o);
}