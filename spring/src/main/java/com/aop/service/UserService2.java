package com.aop.service;

import com.aop.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author pengwei
 * @date 2020/8/3
 */
@Component
public class UserService2 {
    public void login(User user) {
        System.out.println("user ok");
    }

    public void registry(User user) {
        System.out.println("user add");
    }
}
