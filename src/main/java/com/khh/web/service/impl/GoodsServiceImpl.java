package com.khh.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.khh.common.bean.GoodsBean;
import com.khh.common.bean.PagerBean;
import com.khh.common.constant_.Const;
import com.khh.web.dao.GoodsMapper;
import com.khh.web.domain.Goods;
import com.khh.web.service.interface_.GoodsService;
import com.khh.web.utils.BeanUtilEx;
import com.khh.web.utils.MoneyConvert;
import com.khh.web.utils.MyFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public boolean insert(GoodsBean goodsBean, MultipartFile[] files) {
        //1 bean转domain
        Goods good = (Goods) BeanUtilEx.copyProperties2(new Goods(), goodsBean);
        //1.1金钱计算
        good.setPrice(MoneyConvert.moneyStrToLong(goodsBean.getPrice()));
        good.setPromotinalPrice(MoneyConvert.moneyStrToLong(goodsBean.getPromotinalPrice()));
        good.setPostfree(MoneyConvert.moneyStrToLong(goodsBean.getPostfree()));
        //1.2放入时间
        good.setCreateTime(new Date());


        //2 添加图片,并修改图片名称，保存图片
        List<String> imgList = MyFileUtils.saveFile(files);
        String pictures = JSONObject.toJSONString(imgList);
        //2.1将所有图片地址保存到实例
        good.setPictures(pictures);

        //保存商品
        int insert = goodsMapper.insert(good);

        return insert == 1;
    }

    @Override
    public boolean findInPageByKey(PagerBean<GoodsBean> pagerBean) {

        GoodsBean key = pagerBean.getT();
        Goods goods = key.vo2Domain();

        //先获取有多少条记录数
        int totalCount = goodsMapper.findCountWithKeyAndShopId(goods);
        pagerBean.setTotalCount(totalCount);

        //获取总页数
        if(totalCount % pagerBean.getPageSize() == 0){
            pagerBean.setPageCount(totalCount / pagerBean.getPageSize());
        }else{
            pagerBean.setPageCount(totalCount / pagerBean.getPageSize() + 1);
        }

        int start = (pagerBean.getPageNo()-1) * pagerBean.getPageSize();
        pagerBean.setStart(start);
        //查询
        List<Goods> list = goodsMapper.findBeanInPageWithKeyAndShopId(start,pagerBean.getPageSize(),goods);
        if(list == null){
            return false;
        }

        List<GoodsBean> goodsBeanList = new ArrayList<>();
        for(Goods g : list){
            goodsBeanList.add(g.domain2Vo());
        }

        pagerBean.setData(goodsBeanList);
        return true;
    }

    @Override
    public boolean deleteById(String id) {
        return  goodsMapper.deleteById(id) == 1;
    }

    @Override
    public GoodsBean findById(String id) {

        Goods goods = goodsMapper.findById(id);
        GoodsBean goodsBean = goods.domain2Vo();
        return goodsBean;
    }

    @Override
    public boolean updateState(String id, int state) {

        return  goodsMapper.updateState(id,state) == 1;
    }

    @Override
    public boolean update(GoodsBean goodsBean, MultipartFile[] files) {
        //1 bean转domain
        Goods good = (Goods) BeanUtilEx.copyProperties2(new Goods(), goodsBean);
        //1.1金钱计算
        good.setPrice(MoneyConvert.moneyStrToLong(goodsBean.getPrice()));
        good.setPromotinalPrice(MoneyConvert.moneyStrToLong(goodsBean.getPromotinalPrice()));
        good.setPostfree(MoneyConvert.moneyStrToLong(goodsBean.getPostfree()));

        //2 添加图片,并修改图片名称，保存图片
        List<String> imgList = MyFileUtils.saveFile(files);
        String pictures = JSONObject.toJSONString(imgList);
        //2.1将所有图片地址保存到实例
        good.setPictures(pictures);

        int update = goodsMapper.updateByPrimaryKeySelective(good);
        return update == 1;
    }


}
