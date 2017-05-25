package com.khh.web.service.interface_;


import com.khh.common.bean.CartBean;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface CartService {

    /**
     * 添加商品到购物车
     * @param cartBean
     * @return
     */
    boolean insert(CartBean cartBean);
}
