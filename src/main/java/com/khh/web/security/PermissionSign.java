package com.khh.web.security;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 951087952@qq.com on 2017/4/17.
 */
public class PermissionSign {

    private PermissionSign(){}

    /**
     * 普通用户所拥有的权限标识
     */
    public static final String USER_All = "user:*";

    /**
     * 店铺商家所拥有的权限标识
     */
    public static final String SHOP_All = "shop:*";

    /**
     * 超级管理员所拥有的权限标识
     */
    public static final String ADMIN_ALL = "admin:*";

    /**
     * 管理普通用户的权限标识
     */
    public static final String USER_MANAGER = "user:manager";

    /**
     * 管理店铺信息的权限标识
     */
    public static final String SHOP_MANAGER = "shop:manager";



    /**
     * 存放所有权限的map
     */
    public static final Map<String,Object> PERMISSSION_MAP = new HashMap<String,Object>();

    static{
        PERMISSSION_MAP.put("所有用户权限",USER_All);
        PERMISSSION_MAP.put("所有商家权限",SHOP_All);
        PERMISSSION_MAP.put("用户管理权限",USER_MANAGER);
        PERMISSSION_MAP.put("商家管理权限",SHOP_MANAGER);
        PERMISSSION_MAP.put("所有管理员权限",ADMIN_ALL);
    }

}
