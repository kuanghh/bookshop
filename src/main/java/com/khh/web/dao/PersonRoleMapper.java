package com.khh.web.dao;

import com.khh.web.domain.PersonRole;

public interface PersonRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(PersonRole record);

    int insertSelective(PersonRole record);

    PersonRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PersonRole record);

    int updateByPrimaryKey(PersonRole record);
}