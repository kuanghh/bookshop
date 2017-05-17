package com.khh.web.service.impl;

import com.khh.web.dao.PermissionMapper;
import com.khh.web.domain.Permission;
import com.khh.web.service.interface_.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 951087952@qq.com on 2017/5/16.
 */
@Service("permissionService")
public class PermissionServiceImpl  implements PermissionService{

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int insert(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public List<Permission> findAllByRoleId(String id) {
        return permissionMapper.findAllByRoleId(id,true);
    }
}
