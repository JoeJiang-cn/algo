package com.joe.algo.structure;

public class LRUCache {
    private ListNode[] hashTable = new ListNode[10000];
    private int capacity;
    private int count = 0;
    private ListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }

    public int get(int key) {
        ListNode node = hashTable[key];
        if (node == null || node.data == -1) {
            return -1;
        } else {
            // move node
            node.prev.next = node.next;
            node.next.prev = node.prev;
            toTail(node);
            return node.data;
        }
    }

    public void put(int key, int value) {
        ListNode node = hashTable[key];
        if (node != null) {
            node.data = value;
            // move node
            node.prev.next = node.next;
            node.next.prev = node.prev;
            toTail(node);
        } else {
            // 新数据
            node = new ListNode(value);
            if (count == capacity) {
                ListNode head_next = head.next;
                head.next = head_next.next;
                head_next.next.prev = head;
                head_next.data = -1;
                count--;
            }
            toTail(node);
            hashTable[key] = node;
            count++;
        }
    }

    private void toTail(ListNode node) {
        ListNode prev_tail = tail.prev;
        prev_tail.next = node;
        node.prev = prev_tail;
        node.next = tail;
        tail.prev = node;
    }

    private class ListNode {
        public int data;
        public ListNode prev;
        public ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }
}
