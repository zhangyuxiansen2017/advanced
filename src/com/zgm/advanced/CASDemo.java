package com.zgm.advanced;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mr. Zhang
 * @description
 * @date 2019/4/18 11:45
 * @website https://www.zhangguimin.cn
 *
 * 1 CAS是什么？ ===>compareAndSet
 *      比较并交换
 *
 *
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        atomicInteger.compareAndSet(5,10);
        atomicInteger.compareAndSet(5,1024);
        System.out.println(atomicInteger.get());
        atomicInteger.getAndIncrement();
    }
}
