package com.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * 额外功能 MethodInterceptor(cglib)
 * methodinterceptor 接口：额外功能可以根据需要运行在原始方法执行 前、后、前后。
 *
 * @author pengwei
 * @date 2020/8/2
 */
public class Before1 implements MethodInterceptor {

    /**
     * * 参数：MethodInvocation：额外功能所增加给的那个原始方法 (login, register)
     * * 返回值：Object：原始方法的返回值 (没有就返回 null)
     * * invocation.proceed()：原始方法运行
     *
     * @param methodInvocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("---logging");
        Object proceed = methodInvocation.proceed();
        System.out.println("---logging");
        return proceed;

    }
}
