package com.zgm.advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Mr. Zhang
 * @description 锁：
 *                  公平锁/非公平锁
 *                  可重入锁（又称递归锁）
 *                  自旋锁
 *                  独占锁（写锁）/共享锁（读锁）/互斥锁
 * @date 2019-04-15 10:08
 * @website https://www.zhangguimin.cn
 */
public class Main {


}

class SingleonDemo {
    private static volatile SingleonDemo instance = null;

    private SingleonDemo() {
        System.out.println(Thread.currentThread().getName());
    }

    public static SingleonDemo getInstance() {
        //双重校验机制
        if (instance == null) {
            synchronized (SingleonDemo.class) {
                if (instance == null) {
                    instance = new SingleonDemo();
                }
            }
        }
        return instance;
    }
}

class  ReSortSeqDemo{
    int a = 0;
    boolean flag = false;
    public void method01(){
        a = 1;
        flag = true;
    }
    //多线程环境中线程交替执行，由于编译器优化重排的存在，两个线程中使用的变量能否保持一致性时无法确定的，结果无法预测
    public void method02(){
        if (flag) {
            a = a+5;
            System.out.println("******retValue" + a);
        }
    }
}