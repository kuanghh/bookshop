package com.khh.web.security;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 951087952@qq.com on 2017/4/17.
 */
public class RoleSign {

    private RoleSign(){}


    /**
     * 管理员 标识
     */
    public static final String SYSTEMADMIN = "sys_admin";

    /**
     * 普通用户 标识
     */
    public static final String SIMPLEUSER = "simple_user";

    /**
     * 店铺商家 标识
     */
    public static final String SHOP = "shop_user";


    public static Map<String,Object> ROLESMAP = new HashMap<String,Object>();

    static{
        ROLESMAP.put("管理员",SYSTEMADMIN);
        ROLESMAP.put("普通用户",SIMPLEUSER);
        ROLESMAP.put("店铺商家",SHOP);
    }

}
