package com.khh.web.dao;



import com.khh.web.domain.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    /**
     * 添加新的权限
     * @param permission
     * @return
     */
    int insert(Permission permission);


    /**
     * 更新权限信息，只对有效的权限进行更新(即对is_valid为1的更新)
     * @param permission
     * @return
     */
    int update(Permission permission);

    /**
     * 根据id查询权限信息,可选择有效还是无效
     * @param id
     * @return
     */
    Permission findById(@Param("id") String id,@Param("isValid") boolean isValid);

    /**
     * 根据角色id查询所有权限,可选择 !权限!和!角色权限关系! 是否有效
     * @param id
     * @return
     */
    List<Permission> findAllByRoleId(@Param("id")String id,@Param("isValid") boolean isValid);


    /**
     * 查询所有权限，可选择有效还是无效
     * @return
     */
    List<Permission> findAll(@Param("isValid") boolean isValid);
}