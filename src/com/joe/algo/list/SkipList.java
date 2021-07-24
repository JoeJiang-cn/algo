package com.joe.algo.list;

import java.util.Random;

/**
 * 跳表
 */
public class SkipList {
    private static final double PROMOTE_RATE = 0.5;
    private Node head, tail;
    private int maxLevel;

    public SkipList() {
        // 初始化
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.right = tail;
        tail.left = head;
    }

    /**
     * 查找结点
     * @param data
     * @return
     */
    public Node search(int data) {
        Node p = findNode(data);
        if (p.data == data) {
            System.out.println("找到结点：" + data);
            return p;
        }
        System.out.println("未找到结点：" + data);
        return null;
    }

    /**
     * 找到对应的前驱结点
     * @param data
     * @return
     */
    private Node findNode(int data) {
        // 每次都从头开始找
        Node node = head;
        while(true) {
            while(node.right.data < Integer.MAX_VALUE && node.right.data <= data) {
                node = node.right;
            }
            if (node.down == null) {
                break;
            }
            node = node.down;
        }
        return node;
    }

    /**
     * 插入结点
     * @param data
     */
    public void insert(int data) {
        Node preNode = findNode(data);
        // 如果data相同，直接返回
        if (preNode.data == data) {
            return;
        }
        Node node = new Node(data);
        appendNode(preNode, node);
        int currentLevel = 0;
        Random random = new Random();
        while(random.nextDouble() < PROMOTE_RATE) {
            // 晋升
            if (currentLevel == maxLevel) {
                // 加一层
                addLevel();
            }
            while(preNode.up == null) {
                // 找到有上方结点的前置结点
                preNode = preNode.left;
            }
            // 跳到上一层
            preNode = preNode.up;
            Node upperNode = new Node(data);
            appendNode(preNode, upperNode);
            // 下指针和上指针
            upperNode.down = node;
            node.up = upperNode;
            node = upperNode;
            currentLevel++;
        }
    }

    /**
     * 在前置结点后加上新结点
     * @param preNode
     * @param newNode
     */
    private void appendNode(Node preNode, Node newNode) {
        newNode.left = preNode;
        newNode.right = preNode.right;
        preNode.right.left = newNode;
        preNode.right = newNode;
    }

    private void addLevel() {
        maxLevel++;
        Node p1 = new Node(Integer.MIN_VALUE);
        Node p2 = new Node(Integer.MAX_VALUE);
        p1.right = p2;
        p2.left = p1;

        p1.down = head;
        head.up = p1;
        head = p1;

        p2.down = tail;
        tail.up = p2;
        tail = p2;
    }

    public boolean remove(int data) {
        Node removedNode = search(data);
        if (removedNode == null) {
            return false;
        }
        // 删除这个结点有关的索引
        int currentLevel = 0;
        while(removedNode != null) {
            removedNode.right.left = removedNode.left;
            removedNode.left.right = removedNode.right;
            if (currentLevel != 0 && removedNode.left.data == Integer.MIN_VALUE && removedNode.right.data == Integer.MAX_VALUE) {
                removeLevel(removedNode.left);
            } else {
                currentLevel++;
            }
            removedNode = removedNode.up;
        }
        return true;
    }

    private void removeLevel(Node leftNode) {
        Node rightNode = leftNode.right;
        if (leftNode.up == null) {
            // 最高层
            leftNode.down.up = null;
            rightNode.down.up = null;
        } else {
            leftNode.down.up = leftNode.up;
            leftNode.up.down = leftNode.down;
            rightNode.down.up = rightNode.up;
            rightNode.up.down = rightNode.down;
        }
        maxLevel--;
    }

    public void printList() {
        Node node = head;
        while (node.down != null) {
            node = node.down;
        }
        while (node.right.data < Integer.MAX_VALUE) {
            System.out.println(node.right.data);
            node = node.right;
        }
        System.out.println();
    }

    public class Node {
        public int data;
        // 前后上下都有指针
        public Node up, down, left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}
