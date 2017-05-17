package com.khh.web.domain;

import java.io.Serializable;

public class Admin extends Person implements Serializable{

    private String name;

    public Admin(){
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

}