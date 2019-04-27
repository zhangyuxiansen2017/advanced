package com.zgm.advanced;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Mr. Zhang
 * @description
 * @date 2019/4/23 11:04
 * @website https://www.zhangguimin.cn
 * ArrayBlockingQueue: 是一个基于数组结构的有界阻塞队列，此队列按FIFO原则对元素进行排序。
 * LikedBlockingQueue: 一个基于链表结构的阻塞队列，此队列按FIFO排序元素，吞吐量通常要高于ArrayBlockingQueue.
 * SynchronousQueue: 一个不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入操作一致处于阻塞状态，吞吐量通常高于
 *
 * 1 队列
 *
 * 2 阻塞队列
 *  2.1 阻塞队列有没有好的一面
 *  2.2 不得不阻塞，你如何管理
 */
public class BlockingQueueDemo {


    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.add("x"));

    }
}
