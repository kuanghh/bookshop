package com.khh.web.domain;

import com.khh.web.utils.CodeUtils;

import java.io.Serializable;

public class Category implements Serializable{
    private String id;

    private String name;

    //默认有效
    private boolean isValid = true;

    public Category(){
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

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
}