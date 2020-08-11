package com.mybatis.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author pengwei
 * @date 2020/8/7
 */
public class User implements Serializable {
    private int id;
    private String name;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
