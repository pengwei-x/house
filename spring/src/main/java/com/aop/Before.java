package com.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 实现 MethodBeforeAdvice
 * 额外功能在方法之前运行
 *
 * @author pengwei
 * @date 2020/8/2
 */
public class Before implements MethodBeforeAdvice {


    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("before method log  ");
    }
}
