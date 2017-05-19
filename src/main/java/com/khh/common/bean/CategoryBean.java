package com.khh.common.bean;

import com.khh.web.utils.CodeUtils;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/19.
 * 类别bean
 */
public class CategoryBean implements Serializable{

    private String id;

    private String name;

    public CategoryBean(){
        this.id = CodeUtils.getUUID();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


}
