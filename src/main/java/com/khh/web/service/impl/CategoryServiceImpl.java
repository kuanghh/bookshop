package com.khh.web.service.impl;

import com.khh.common.bean.CategoryBean;
import com.khh.web.dao.CategoryMapper;
import com.khh.web.domain.Category;
import com.khh.web.service.interface_.CategoryService;
import com.khh.web.utils.BeanUtilEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public boolean insert(CategoryBean categoryBean) {
        //bean转domain
        Category category = (Category) BeanUtilEx.copyProperties2(new Category(),categoryBean);
        return categoryMapper.insert(category) == 1 ? true :false;
    }

    @Override
    public int findByName(String name) {
        return categoryMapper.findNameIsExist(name);
    }

    @Override
    public List<CategoryBean> findAll() {
        return categoryMapper.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        return categoryMapper.deleteById(id) == 1 ? true : false;
    }


}
