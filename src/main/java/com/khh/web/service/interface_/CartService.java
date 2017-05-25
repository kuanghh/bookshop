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

    /**
     * 根据id删除记录
     * @param id
     * @return
     */
    boolean deleteById(String id);

    /**
     * 根据id，改变购物车中某商品的数量
     * @param id
     * @param num
     * @return
     */
    String changeNum(String id, Integer num);

    /**
     * 计算总价格
     * @param id
     * @return
     */
    String findForCaleTotalPrice(String id);
}
