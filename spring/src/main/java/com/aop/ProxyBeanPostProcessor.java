package com.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Spring 工厂如何加工原始对象
 * 思路分析：主要通过 BeanPostProcessor 将原始对象加工为代理对象
 * <p>
 * 会处理所有bean
 *
 * @author pengwei
 * @date 2020/8/11
 */
@Component
public class ProxyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 前置处理方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     * cglib 动态代理
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(bean.getClass().getClassLoader());
        enhancer.setSuperclass(bean.getClass());
        MethodInterceptor interceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("--log--before--");
                Object invoke = method.invoke(bean, objects);
                System.out.println("--log --after--");
                return invoke;
            }
        };
        enhancer.setCallback(interceptor);
        return enhancer.create();
    }

    /**
     * 后置处理方法  jdk 动态代理
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
  /*  @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {

        *//**
     * 额外功能
     *//*
        InvocationHandler interceptor = new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("额外功能----log---");
                Object invoke = method.invoke(bean,args);
                return invoke;
            }
        };
        return Proxy.newProxyInstance(ProxyBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), interceptor);
    }*/
}
