package com.khh.web.service.interface_;

import com.khh.common.bean.PagerBean;
import com.khh.common.bean.ShopRegisterBean;

/**
 * Created by 951087952@qq.com on 2017/5/17.
 * 店铺服务接口
 */
public interface ShopService {

    int insert(ShopRegisterBean shopRegisterBean);

    /**
     * 根据关键字分页查询商铺
     * @param pagerBean
     * @return
     */
    boolean findInPageAndKey(PagerBean<ShopRegisterBean> pagerBean);

    /**
     * 根据Id删除
     * @param id
     * @return
     */
    boolean deleteById(String id);

    /**
     * 认证商家
     * @param id
     * @return
     */
    boolean updateForAuthen(String id);

    /**
     * 根据店主id查询当前商铺信息
     * @param id
     * @return
     */
    ShopRegisterBean findById(String id);

    /**
     * 修改店铺信息
     * @param shopRegisterBean
     * @return
     */
    boolean updateShop(ShopRegisterBean shopRegisterBean);
}
