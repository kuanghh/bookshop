package com.khh.web.service.interface_;

import com.khh.common.bean.GoodsBean;
import com.khh.common.bean.PagerBean;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface GoodsService {
    /**
     * 添加商品
     * @param goodsBean
     * @param files
     * @return
     */
    boolean insert(GoodsBean goodsBean, MultipartFile[] files);

    /**
     * 根据关键字,商家的id,分页查询所有商品
     * @param pagerBean
     * @return
     * @throws Exception
     */
    boolean findInPageByKey(PagerBean<GoodsBean> pagerBean);
}
