package com.aop.proxy;

import com.aop.entity.User;
import com.aop.service.UserService2;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib 动态代理
 * @author pengwei
 * @date 2020/8/3
 */
public class CglibDynamicTest {
    public static void main(String[] args) {


        final UserService2 userService2 = new UserService2();

        /*
         2. 通过 cglib 方式创建动态代理对象
         对比 jdk 动态代理 ---> Proxy.newProxyInstance(classLoader, interface, invocationHandler);
         n. [遗] 增强子；强化剂；增加者
         Enhancer.setClassLoader()
         Enhancer.setSuperClass()
         Enhancer.setCallBack() ---> MethodInterceptor(cglib)
         Enhancer.create() ---> 创建代理对象
         */


        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(CglibDynamicTest.class.getClassLoader());
        enhancer.setSuperclass(userService2.getClass());

        MethodInterceptor interceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib --- logging---");
                return  method.invoke(userService2,args);
            }
        };

        enhancer.setCallback(interceptor);
        UserService2 userServiceProxy = (UserService2)enhancer.create();
        userServiceProxy.login(new User());
        userServiceProxy.registry(new User());

    }
}
