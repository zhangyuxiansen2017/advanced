package com.zgm.advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Mr. Zhang
 * @description
 * @date 2019/4/19 10:46
 * @website https://www.zhangguimin.cn
 *
 * 多个线程同时读一个资源没任何问题，所以为了满足并发量，读取共享资源应该是可以同时进行。
 * 但是
 * 如果一个线程想去修改共享资源，就不应该再有其他线程可以对该资源进行读或写。
 * 小总结：
 *      读-读能共享
 *      读-写不能共享
 *      写-写不能共享
 */
public class ReadWriteLockDemo {
    /**
     * 读写锁
     */
    private volatile Map<Integer, Integer> map = new HashMap<>();
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void put(Integer key, Integer val) {
        rwl.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始写入");
            map.put(key, val);
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + "写入完成");
        } catch (InterruptedException e) {

        } finally {
            rwl.writeLock().unlock();
        }
    }

    public void get() {
        rwl.readLock().lock();
        try {
            map.entrySet().forEach(p -> {
                System.out.println(Thread.currentThread().getName() + "开始读取：" + p.getValue());
            });
        } finally {
            rwl.readLock().unlock();
        }
    }




    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        for (int i = 0; i < 5; i++) {
            final int kv = i;
            new Thread(() -> {
                readWriteLockDemo.put(kv, kv);
            },"AA").start();
        }

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                readWriteLockDemo.get();
            },"BB").start();
        }
    }
}
