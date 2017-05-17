package com.khh.web.service.impl;

import com.khh.web.dao.RoleMapper;
import com.khh.web.dao.RolePermissionMapper;
import com.khh.web.domain.Role;
import com.khh.web.service.interface_.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 951087952@qq.com on 2017/5/16.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService{

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RoleMapper roleMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public List<Role> findAllByPersonId(String id) {
        return roleMapper.findAllByPersonId(id);
    }


}
