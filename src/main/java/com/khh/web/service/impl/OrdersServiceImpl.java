package com.khh.web.service.impl;

import com.khh.common.bean.OrdersBean;
import com.khh.common.bean.PagerBean;
import com.khh.web.dao.CartMapper;
import com.khh.web.dao.GoodsMapper;
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
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/5/26.
 */
@Service("orderService")
public class OrdersServiceImpl  implements OrdersService{

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private GoodsMapper goodsMapper;



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
            if(cart.getNum() > goods.getNum()) return "商品" + goods.getName()+ "货存不足";
            if(goods.getState() == Goods.STATE_NOVALID) return  "商品" + goods.getName() + "已经下架";

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

            //更新库存数量
            goods.setNum(goods.getNum() - cart.getNum());

            goodsMapper.updateByPrimaryKeySelective(goods);

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



    @Override
    public boolean findInPageWithKey(PagerBean<OrdersBean> pagerBean) {

        //先获取有多少条记录数
        OrdersBean ob = pagerBean.getT();
        int totalCount = ordersMapper.findCountWithKey(ob.vo2Domain());
        pagerBean.setTotalCount(totalCount);

        //获取总页数
        if(totalCount % pagerBean.getPageSize() == 0){
            pagerBean.setPageCount(totalCount / pagerBean.getPageSize());
        }else{
            pagerBean.setPageCount(totalCount / pagerBean.getPageSize() + 1);
        }
        //计算查询开始位置
        int start = (pagerBean.getPageNo()-1) * pagerBean.getPageSize();
        pagerBean.setStart(start);
        //查询
        List<Orders> list = ordersMapper.findBeanInPage(start,pagerBean.getPageSize(),ob.vo2Domain());

        if(list == null){
            return false;
        }
        List<OrdersBean> ordersBeanList = list.stream().map(Orders::domain2Vo).collect(Collectors.toList());
        pagerBean.setData(ordersBeanList);
        return true;

    }

    @Override
    public boolean updateOrdersState(String id) {
        Orders orders = new Orders();
        orders.setId(id);
        orders.setSerial(null);
        orders.setState(Orders.ORDERS_SEND);
        return ordersMapper.updateByPrimaryKeySelective(orders) == 1;

    }
}
