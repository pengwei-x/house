package com;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pengwei
 * @date 2020/8/10
 */
public class Test {

    @org.junit.Test
    public void test1(){
        //AtomicInteger
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.addAndGet(1);


    }
}
