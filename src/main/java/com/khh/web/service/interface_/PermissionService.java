package com.khh.web.service.interface_;

import com.khh.web.domain.Permission;

import java.util.List;

/**
 * Created by 951087952@qq.com on 2017/5/16.
 */
public interface PermissionService {

    /**
     * 增加权限
     * @param permission
     * @return
     */
    int insert(Permission permission);

    /**
     * 通过角色id查询所有权限
     * @param id
     * @return
     */
    List<Permission> findAllByRoleId(String id);


}
