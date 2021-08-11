package com.joe.algo.structure.list;

/**
 * @author Joe
 * TODO description
 * 2021/8/1 14:40
 */
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this(value, null);
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public boolean equals(Object node) {
        if (node == this) {
            return true;
        }
        if (node.getClass() == getClass()) {
            if (this.value == ((Node)node).value) {
                return true;
            }
        }
        return false;
    }
}
