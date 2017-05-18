package com.khh.web.service.impl;

import com.khh.common.bean.ShopRegisterBean;
import com.khh.web.dao.PersonMapper;
import com.khh.web.dao.PersonRoleMapper;
import com.khh.web.dao.RoleMapper;
import com.khh.web.dao.ShopMapper;
import com.khh.web.domain.*;
import com.khh.web.security.RoleSign;
import com.khh.web.service.interface_.ShopService;
import com.khh.web.utils.BeanUtilEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static org.apache.ibatis.ognl.DynamicSubscript.first;

/**
 * Created by 951087952@qq.com on 2017/5/17.
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService{

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ShopMapper shopMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private PersonMapper personMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private PersonRoleMapper personRoleMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int insert(ShopRegisterBean shopRegisterBean) {
        //bean转domain
        Person person = (Person) BeanUtilEx.copyProperties2(new Person(), shopRegisterBean);
        Shop shop = (Shop) BeanUtilEx.copyProperties2(new Shop(), shopRegisterBean);

        //设置注册时间
        shop.setCreateTime(new Date());
        //还没有管理员认证
        shop.setState(Shop.DISABLE);

        int first = personMapper.insert(person);
        int secound = shopMapper.insert(shop);

        /**赋予商家角色**/
        Role role = roleMapper.findBySign(RoleSign.SHOP);
        int third = personRoleMapper.insert(new PersonRole(person.getId(),role.getId()));

        if(first == 1 && secound == 1 && third == 1){
            return 1;
        }
        return 0;
    }
}
