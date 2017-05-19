package com.khh.web.dao;

import com.khh.common.bean.CategoryBean;
import com.khh.web.domain.Category;

import java.util.List;

public interface CategoryMapper {

    /**
     * 添加分类
     * @param category
     * @return
     */
    int insert(Category category);

    /**
     * 判断是否存在当前分类(只查询有效数据)
     * @param name
     * @return
     */
    int  findNameIsExist(String name);

    /**
     * 获取全部分类
     * @return
     */
    List<CategoryBean> findAll();

    /**
     * 根据id删除(假删除)
     * @param id
     * @return
     */
    int deleteById(String id);
}