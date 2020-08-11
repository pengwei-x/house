package com.aop.proxy;


import com.aop.entity.User;
import com.aop.service.UserService;
import com.aop.service.UserService2;
import com.aop.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author pengwei
 * @date 2020/8/2
 */
public class UserServiceProxyHandlerTest {

    /**
     * 静态代理
     */
    @Test
    public void test() {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("/spring-context.xml");
        UserServiceProxyHandler userServiceProxyHandler = classPathXmlApplicationContext.getBean("userServiceProxyHandler", UserServiceProxyHandler.class);
        userServiceProxyHandler.login(new User());


    }

    @Test
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring-context.xml");
        UserService userService = applicationContext.getBean("userServiceImpl", UserServiceImpl.class);
        userService.login(new User());
        userService.registry(new User());
    }

    @Test
    public void test3() {

        // JDK动态代理
        //    public static Object newProxyInstance(ClassLoader loader,
        //                                          Class<?>[] interfaces,
        //                                          InvocationHandler h)

        final UserService userService = new UserServiceImpl();

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("额外功能");
                Object invoke = method.invoke(userService, args);
                return invoke;
            }
        };
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(UserServiceProxyHandlerTest.class.getClassLoader(), userService.getClass().getInterfaces(), invocationHandler);
        userServiceProxy.login(new User());
    }

    @Test
    public void test4() {
            ApplicationContext applicationContext=new ClassPathXmlApplicationContext("/spring-annotation.xml");
            UserService userServiceImpl = (UserService) applicationContext.getBean("userServiceImpl");
            userServiceImpl.login(new User());
        }


    @Test
    public void test5() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("/spring-annotation.xml");
        UserService2 userServiceImpl = (UserService2) applicationContext.getBean("userService2");
        userServiceImpl.login(new User());
    }
}