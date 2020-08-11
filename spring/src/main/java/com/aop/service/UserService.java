package com.aop.service;

import com.aop.annotation.Log;
import com.aop.entity.User;

/**
 * @author pengwei
 * @date 2020/8/2
 */

public interface UserService {
    /**
     * 登录
     * @param user
     */
    void login(User user);

    void registry(User user);
}
