package com.aop.proxy;

import com.aop.entity.User;
import com.aop.service.UserService;
import com.aop.service.UserServiceImpl;

/**静态代理类使用方式
 * @author pengwei
 * @date 2020/8/2
 */
public class UserServiceProxyHandler implements UserService {

    private  UserService userService;
    @Override
    public void login(User user) {
        System.out.println("----log---");
        userService.login(user);

    }

    @Override
    public void registry(User user) {
        System.out.println("----log---");
        userService.registry(user);
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
