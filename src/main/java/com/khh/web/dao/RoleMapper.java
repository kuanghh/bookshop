package com.khh.web.dao;

import com.khh.common.bean.RoleBean;
import com.khh.web.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    /**
     * 添加
     * @param role
     * @return
     */
    int insert(Role role);

    /**
     * 更新
     * @param role
     * @return
     */
    int update(Role role);

    /**
     * 根据id查询(查询有效或无效数据)
     * @param id
     * @return
     */
    Role findById(@Param(value = "id")String id, @Param(value = "isValid") boolean isValid);

    /**
     * 根据id返回角色的详细信息(只查询有效数据)
     * @param id
     * @return
     */
    RoleBean findDetailById(String id);

    /**
     * 根据人Id查询所有角色信息(只查询有效数据)
     * @param id
     * @return
     */
    List<Role> findAllByPersonId(String id);

    /**
     * 返回所有详细的角色信息(只查询有效数据)
     * @return
     */
    List<RoleBean> findAllWithDetail();

    /**
     * 通过角色标识查询角色信息(只查询有效数据)
     * @param sign
     * @return
     */
    Role findBySign(String sign);
}