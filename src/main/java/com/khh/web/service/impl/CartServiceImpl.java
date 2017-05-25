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
        int i = cartMapper.findByGoodIdAndUserId(cartBean.getGoodsId(),cartBean.getUserId());
        //1.1如果没有，则购物车表增加一条记录
        if(i == 0){
            return cartMapper.insert(cart) == 1;

        }else if(i == 1){    //1.2如果有,且记录数为1，则那条购物车记录中的数量+1

            cart.setNum(cart.getNum() + 1);
            return cartMapper.updateByGoodsIdAndUserId(cart) == 1;
        }else{

            //1.3 若记录数不为1和0，则抛出异常
            throw new RuntimeException();
        }
    }
}
