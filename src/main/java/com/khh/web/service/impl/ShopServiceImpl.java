package com.khh.web.service.impl;

import com.khh.common.bean.PagerBean;
import com.khh.common.bean.ShopRegisterBean;
import com.khh.common.bean.UserRegisterBean;
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
import java.util.List;

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


    @Override
    public boolean findInPageAndKey(PagerBean<ShopRegisterBean> pagerBean) {
        //先获取有多少条记录数
        int totalCount = shopMapper.findCountWithKey(pagerBean.getKeyMap());
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
        List<ShopRegisterBean> list = shopMapper.findBeanInPage(pagerBean);
        if(list == null){
            return false;
        }

        pagerBean.setData(list);
        return true;
    }

    @Override
    public boolean deleteById(String id) {
        if(personMapper.deleteById(id) == 0){
            return false;
        }
        if(shopMapper.deleteById(id) == 0){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateForAuthen(String id) {
        Shop shop = new Shop();
        shop.setId(id);
        shop.setState(Shop.ENABLE);
        shop.setAuthenticationTime(new Date());
        return shopMapper.update(shop) == 1 ;
    }

    @Override
    public ShopRegisterBean findById(String id) {

        return shopMapper.findById(id);
    }


    @Override
    public boolean updateShop(ShopRegisterBean shopRegisterBean) {
        //bean转domain
        Person person = (Person) BeanUtilEx.copyProperties2(new Person(), shopRegisterBean);
        Shop shop = (Shop) BeanUtilEx.copyProperties2(new Shop(), shopRegisterBean);

        int first = personMapper.update(person);
        int secound = shopMapper.update(shop);

        return first == 1 && secound == 1;
    }
}
