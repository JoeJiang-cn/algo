package com.joe.algo.structure.list;

/**
 * @author Joe
 * 基于链表的队列
 * 2021/8/1 14:44
 */
public class LinkedQueue {
    private Node head;
    private Node tail;

    public LinkedQueue(int value) {
        head = new Node(value);
        tail = head;
    }

    /**
     * 入队
     * @param value
     */
    public void enqueue(int value) {
        Node node = new Node(value);
        tail.next = node;
        tail = node;
    }

    /**
     * 出队
     * @return
     */
    public Node dequeue() {
        if (head == tail) {
            return null;
        }
        Node node = head;
        head = head.next;
        return node;
    }

}
