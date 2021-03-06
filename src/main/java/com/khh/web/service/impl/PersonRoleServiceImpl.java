package com.khh.web.service.impl;

import com.khh.web.dao.PersonRoleMapper;
import com.khh.web.domain.PersonRole;
import com.khh.web.service.interface_.PersonRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 951087952@qq.com on 2017/5/16.
 */
@Service("personRoleService")
public class PersonRoleServiceImpl implements PersonRoleService{
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private PersonRoleMapper personRoleMapper;

    @Override
    public int insert(PersonRole userRole) {
        return personRoleMapper.insert(userRole);
    }
}
