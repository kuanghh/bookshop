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
        List<String> imgList = new ArrayList<>();
        if(files.length == 0) throw new RuntimeException();
        for (int i = 0; i < files.length; i++) {
            // TODO 图片格式验证
            String fileName = System.currentTimeMillis() + "_" + files[i].getOriginalFilename();
            //2.1保存文件
            try {
                String picPath = Const.IMGSAVEPATH + "/" + fileName;
                files[i].transferTo(new File(picPath));
                //把路径保存imgList
                imgList.add(picPath);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        String pictures = JSONObject.toJSONString(imgList);
        //2.2将所有图片地址保存到实例
        good.setPictures(pictures);

        //保存商品
        int insert = goodsMapper.insert(good);

        return insert == 1;
    }

    @Override
    public boolean findInPageByKey(PagerBean<GoodsBean> pagerBean, String shopId) {

        //先获取有多少条记录数
        int totalCount = goodsMapper.findCountWithKeyAndShopId(pagerBean.getKeyMap(),shopId);
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
        List<GoodsBean> list = goodsMapper.findBeanInPageWithKeyAndShopId(pagerBean,shopId);
        if(list == null){
            return false;
        }

        pagerBean.setData(list);
        return true;
    }
}
