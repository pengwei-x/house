package com.aop.entity;


import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author pengwei
 * @date 2020/8/2
 */
public class User implements Serializable {

    private static final long serialVersionUID = -6717899583376092384L;

    private String name;

    private int age;

    public User() {
        System.out.println("无参构造");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
