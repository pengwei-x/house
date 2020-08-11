package com.aop.proxy;

import com.aop.entity.User;
import com.aop.service.UserService;
import com.aop.service.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author pengwei
 * @date 2020/8/3
 */
public class JdkDynamicTest {
    public static void main(String[] args) {
        /**
         * jdk1.8*以前需要加 final
         */

         final UserService userService = new UserServiceImpl();

        InvocationHandler invocationHandler = new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("---- proxy log ----");
                // 原始方法运行
                return method.invoke(userService, args);
            }
        };

        /**
         * jdk 动态代理
         *public static Object newProxyInstance(ClassLoader loader,
         *                                           Class<?>[] interfaces,
         *                                           InvocationHandler h)
         *         throws IllegalArgumentException
         *       1、 loader  借用类加载器
         *       2、interfaces 目标接口
         *       3、InvocationHandler 目标处理器
         *
         *      1. 借⽤类加载器  TestJDKProxy 或 UserServiceImpl 都可以
         *      2. JDK8.x 前必须加 final
         *      final UserService userService = new UserServiceImpl();
         *
         *
         */
        UserService userServiceProxy= (UserService) Proxy.newProxyInstance(JdkDynamicTest.class.getClassLoader(), userService.getClass().getInterfaces(), invocationHandler);
        userServiceProxy.login(new User());
        userServiceProxy.registry(new User());
    }
}
