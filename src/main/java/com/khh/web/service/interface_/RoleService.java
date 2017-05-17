package com.khh.web.service.interface_;

import com.khh.web.domain.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 951087952@qq.com on 2017/5/15.
 */
public interface RoleService {

    /**
     * 添加新角色
     * @param role
     * @return
     */
    int insert(Role role);

    /**
     * 根据人id查询所有角色
     * @param id
     * @return
     */
    List<Role> findAllByPersonId(String id);


}
