package com.khh.web.service.impl;

import com.khh.common.bean.OrdersBean;
import com.khh.web.dao.CartMapper;
import com.khh.web.dao.OrdersMapper;
import com.khh.web.domain.Cart;
import com.khh.web.domain.Goods;
import com.khh.web.domain.Orders;
import com.khh.web.service.interface_.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */
@Service("orderService")
public class OrdersServiceImpl  implements OrdersService{

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private CartMapper cartMapper;




    @Override
    public String insertOrders(String userId,String acceptAddress) {

        //查询购物车内容
        List<Cart> userCart = cartMapper.findAllByUserId(userId);
        if(userCart == null || userCart.isEmpty()){
            return "购物车为空";
        }

        /**
         * 创建订单列表
         */
        List<Orders> ordersList = new ArrayList<>();

        /**
         * 遍历购物车
         */
        for(Cart cart : userCart){
            Goods goods = cart.getGoods();
            if(cart.getNum() > goods.getNum()) return "商品" + goods.getNum() + "货存不足";
            if(goods.getState() == Goods.STATE_NOVALID) return  "商品" + goods.getNum() + "已经下架";

            Orders orders = new Orders();
            orders.setCreateTime(new Date());
            orders.setUserId(userId);
            orders.setGoodsId(goods.getId());
            orders.setShopId(goods.getShop().getId());
            orders.setNum(cart.getNum());

            //计算单个订单总价 （ 物件价格 * 物件的个数 + 物件的邮费）
            long totalPrice = goods.getPrice() * cart.getNum() + goods.getPostfree();
            orders.setTotalPrice(totalPrice);
            orders.setAddress(acceptAddress);
            //默认未发货
            orders.setState(Orders.ORDERS_NOTSEND);
            ordersList.add(orders);
        }
        /**
         * 以上操作都是查询操作，对数据库不存在添加修改删除，所以一旦不符合要求，可以不用报错，不用回滚
         */

        //批量增加订单
        ordersMapper.insertAll(ordersList);
        //批量修改购物车记录为无效
        cartMapper.updateAllToNoVaild(userCart);

        return "success";
    }
}
