package com.khh.web.domain;

import com.khh.web.utils.CodeUtils;

import java.io.Serializable;

public class PersonRole implements Serializable {
    private String id;

    private String personId;

    private String roleId;

    //默认有效
    private boolean isValid = true;

    public PersonRole(){this.id = CodeUtils.getUUID();}

    public PersonRole(String personId, String roleId) {
        this();
        this.personId = personId;
        this.roleId = roleId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
}