package com.khh.web.service.interface_;

import com.khh.common.bean.OrdersBean;

/**
 * Created by Administrator on 2017/5/26.
 * 订单
 */
public interface OrdersService {
    /**
     * 添加订单
     * @param
     * @return
     */
    String insertOrders(String userId,String acceptAddress);
}
