package com.khh.web.dao;

import com.khh.web.domain.User;

public interface UserMapper {

    /**
     * 用户注册时添加新用户
     * @param user
     * @return
     */
    int insert(User user);
}