package com.khh.web.service.interface_;

import com.khh.common.bean.CategoryBean;
import com.khh.web.domain.Category;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface CategoryService {

    /**
     * 添加分类
     * @param categoryBean
     * @return
     */
    boolean insert(CategoryBean categoryBean);

    /**
     * 根据类别名查询
     * @param name
     * @return
     */
    int findByName(String name);

    /**
     * 获取全部分类
     * @return
     */
    List<CategoryBean> findAll();

    /**
     * 根据Id删除
     * @param id
     * @return
     */
    boolean deleteById(String id);
}
