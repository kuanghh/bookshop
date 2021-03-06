package com.khh.web.service.interface_;

import com.khh.common.bean.PagerBean;
import com.khh.common.bean.UserBean;
import com.khh.common.bean.UserRegisterBean;

import java.util.List;

/**
 * Created by 951087952@qq.com on 2017/5/17.
 * 用户服务接口
 */
public interface UserService {

    int insert(UserRegisterBean registerBean);

    /**
     * 获取全部用户
     * @return
     */
    List<UserRegisterBean> findAllBean();

    /**
     * 根据关键字分页查询用户
     * @param pagerBean
     * @return
     */
    boolean findInPageAndKey(PagerBean<UserRegisterBean> pagerBean);

    /**
     * 根据Id删除用户
     * @return
     */
    boolean deleteById(String id);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    UserBean findById(String id);

    /**
     * 更新用户信息
     * @param userBean
     * @return
     */
    boolean update(UserBean userBean);
}
