package com.joe.algo.structure.array;

import java.util.Arrays;

/**
 * @author Joe
 * 基于数组的队列
 * 2021/8/1 14:39
 */
public class ArrayQueue {
    private int head = 0;
    private int tail = 0;
    private int[] queue;
    private int capacity = 0;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
    }

    /**
     * 入队
     * @param value
     * @return
     */
    public boolean enqueue(int value) {
        if (tail == capacity) {
            if (head == 0) {
                // 队满
                return false;
            } else {
                for (int i = 0; i < tail - head; i++) {
                    // 数据搬移
                    queue[i] = queue[head + i];
                }
                // tail指向新位置
                tail -= head;
                head = 0;
            }
        }
        queue[tail++] = value;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public int dequeue() {
        if (head == tail) {
            return -1;
        }
        return queue[head++];
    }

}
