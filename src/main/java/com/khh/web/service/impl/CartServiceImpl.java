package com.khh.web.service.impl;

import com.khh.common.bean.CartBean;
import com.khh.web.dao.CartMapper;
import com.khh.web.dao.GoodsMapper;
import com.khh.web.domain.Cart;
import com.khh.web.domain.Goods;
import com.khh.web.service.interface_.CartService;
import com.khh.web.utils.BeanUtilEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/5/25.
 */
@Service("cartService")
public class CartServiceImpl  implements CartService{

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private GoodsMapper goodsMapper;


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

    @Override
    public List<CartBean> findAllCartByUserId(String id) {

        List<Cart> list = cartMapper.findAllByUserId(id);
        if(list == null ||list.isEmpty()){
            return null;
        }

        return list.stream().map(Cart::domain2Vo).collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(String id) {
        Cart cart = new Cart();
        cart.setId(id);
        cart.setIsValid(false);
        return cartMapper.updateByPrimaryKeySelective(cart) == 1;
    }

    @Override
    public String changeNum(String id, Integer num) {

        Cart cart = cartMapper.selectByPrimaryKey(id);
        if(cart == null) return "记录不存在";
        String goodsId = cart.getGoodsId();
        //查看商品库存情况
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        if(goods == null) return "商品不存在";
        if(goods.getState() == Goods.STATE_NOVALID) return "商品已经下架";
        if(cart.getNum() + num < 0) return "输入错误";
        if(cart.getNum() + num > goods.getNum()) return "商品活存不足";

        cart.setNum(cart.getNum() + num);
        cart.setUpdateTime(new Date());
        cartMapper.updateByPrimaryKeySelective(cart);
        return null;
    }
}
