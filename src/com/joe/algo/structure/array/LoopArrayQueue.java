package com.joe.algo.structure.array;

/**
 * @author Joe
 * 循环数组队列
 * 2021/8/1 15:30
 */
public class LoopArrayQueue {
    private int head = 0;
    private int tail = 0;
    private int[] queue;
    private int capacity = 0;

    public LoopArrayQueue() {
        this(10);
    }

    public LoopArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
    }

    /**
     * 入队
     * @param value
     */
    public boolean enqueue(int value) {
        if ((tail + 1) % capacity == head) {
            // 队满
            return false;
        }
        queue[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public int dequeue() {
        if (head == tail) {
            // 队空
            return -1;
        }
        int value = queue[head];
        head = (head + 1) % capacity;
        return value;
    }
}
