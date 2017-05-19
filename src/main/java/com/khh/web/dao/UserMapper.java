package com.khh.web.dao;

import com.khh.common.bean.PagerBean;
import com.khh.common.bean.UserRegisterBean;
import com.khh.web.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 用户注册时添加新用户
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 根据Id删除  这里是假删除
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 获取所有有效的用户
     * @return
     */
    List<UserRegisterBean> findAllBean();

    /**
     * 根据关键字获取一共有多少条记录(只查询有效数据)
     * @param keyMap
     * @return
     */
    int findCountWithKey(@Param("keyMap") Map<String,String> keyMap);


    /**
     * 根据关键字分页查询记录（只查询有效数据）
     * @param pagerBean
     * @return
     */
    List<UserRegisterBean> findBeanInPage(PagerBean<UserRegisterBean> pagerBean);



}