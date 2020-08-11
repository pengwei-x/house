package com.aop.service;

import com.aop.annotation.Log;
import com.aop.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author pengwei
 * @date 2020/8/2
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    @Log
    public void login(User user) {
        System.out.println("user ok");
    }

    @Override
    @Log
    public void registry(User user) {
        System.out.println("user add");
    }
}
