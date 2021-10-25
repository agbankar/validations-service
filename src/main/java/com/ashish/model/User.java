package com.ashish.model;

import com.ashish.validations.ErrorCode;
import com.ashish.validations.StringPattern;

public class User {
    @StringPattern(errorCode = ErrorCode.ERR001)
    private String name;
    @StringPattern(errorCode = ErrorCode.ERR002)
    private String id;

    public User() {
    }

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
