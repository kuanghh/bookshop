package com.khh.web.service.impl;

import com.khh.common.bean.CartBean;
import com.khh.web.dao.CartMapper;
import com.khh.web.domain.Cart;
import com.khh.web.service.interface_.CartService;
import com.khh.web.utils.BeanUtilEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2017/5/25.
 */
@Service("cartService")
public class CartServiceImpl  implements CartService{

    @Autowired
    private CartMapper cartMapper;


    @Override
    public boolean insert(CartBean cartBean) {

        //bean 转Domain
        Cart cart = cartBean.vo2Domain();
        cart.setUpdateTime(new Date());


        //1 查看商品是否已经存在购物车
        Cart cartDB = cartMapper.findByGoodIdAndUserId(cartBean.getGoodsId(),cartBean.getUserId());
        //1.1如果没有，则购物车表增加一条记录
        if(cartDB == null){
            return cartMapper.insert(cart) == 1;

        }else{    //1.2如果有,则那条购物车记录中的数量+1
            cartDB.setUpdateTime(new Date());
            cartDB.setNum(cartDB.getNum() + 1);
            return cartMapper.updateByPrimaryKeySelective(cartDB) == 1;
        }
    }
}
