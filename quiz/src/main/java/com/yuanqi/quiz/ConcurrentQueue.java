package com.yuanqi.quiz;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : yuanqi
 */
public class ConcurrentQueue<T> {
    private static ConcurrentQueue<Object> concurrentQueue = new ConcurrentQueue<>();


    private final ReentrantLock lock = new ReentrantLock();

    private final Queue<T> queue = new LinkedList<>();


    public void offer(T element) {
        lock.lock();
        try {
            queue.offer(element);
        } finally {
            lock.unlock();
        }
    }

    public T poll() {
        while (queue.isEmpty()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.lock();
        if (queue.isEmpty()) {
            lock.unlock();
            return poll();
        } else {
            try {
               return queue.poll();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * in this case, I use a 'expected' number of threads to offer and poll a newly created object
     * into/from the queue
     *
     * How to prove it works? when polling objects, I use two ConcurrentHashMap to store the
     * polled put uniq objects and repeat objects.
     * if repeat map is empty, it shows that no reader reads the same stuff
     * on that condition, if stuff map's size is 'expected', it shows no writer's stuff is lost
     */
    @Test
    public void testCase() {
        int expected = 100000;
        ConcurrentHashMap<Object, Object> stuffMap = new ConcurrentHashMap<>();
        ConcurrentHashMap<Object, Object> repeatMap = new ConcurrentHashMap<>();
        for (int i = 0; i < expected; i++) {
            new Thread(() -> concurrentQueue.offer(new Object())).start();
            new Thread(() -> {
                Object object = concurrentQueue.poll();
                if (!stuffMap.containsKey(object)) {
                    stuffMap.put(object, object);
                } else {
                    repeatMap.put(object, object);
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(0, repeatMap.size());
        Assert.assertEquals(expected, stuffMap.size());
    }

}
