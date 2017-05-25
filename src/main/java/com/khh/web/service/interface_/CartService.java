package com.khh.web.service.interface_;


import com.khh.common.bean.CartBean;

import java.util.List;

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

    /**
     * 根据用户id查询所有购物车记录
     * @param id
     * @return
     */
    List<CartBean> findAllCartByUserId(String id);
}
