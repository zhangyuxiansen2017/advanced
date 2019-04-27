package com.zgm.advanced;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Mr. Zhang
 * @description
 * @date 2019/4/18 15:34
 * @website https://www.zhangguimin.cn
 */
public class CollectionSafety {
    public static void main(String[] args) {
        //List<String> list = new ArrayList<>();
        //List<String> list = new Vector<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        //List<String> list = new CopyOnWriteArrayList<>();
        Set<String> set = new CopyOnWriteArraySet<>();
        //Map<String, Object> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
        /**
         * 1 故障现象
         *      java.util.ConcurrentModificationException
         * 2 导致原因
         *      并发争抢修改导致
         * 3 解决方案
         *      3.1 new Vector<>();
         *      3.2 Collections.synchronizedList(new ArrayList<>());
         *             ...Collections.synchronizedMap(new HashMap<>());
         *             ...Collections.synchronizedSet(new HashSet<>());
         *      3.3 new CopyOnWriteArrayList<>();
         *             ...Set<String> set = new CopyOnWriteArraySet<>();
         *             ...Map<String, Object> map = new ConcurrentHashMap<>();
         * 4 优化建议
         */

    }
}
