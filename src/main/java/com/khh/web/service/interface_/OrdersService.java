package com.khh.web.service.interface_;

import com.khh.common.bean.OrdersBean;
import com.khh.common.bean.PagerBean;

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

    /**
     * 根据关键字，分页获取订单
     * @param pagerBean
     * @return
     */
    boolean findInPageWithKey(PagerBean<OrdersBean> pagerBean);

    /**
     * 商家发货
     * @param id
     * @return
     */
    boolean updateOrdersState(String id);
}
