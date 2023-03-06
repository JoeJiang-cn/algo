package com.joe.algo.structure.heap;

import java.util.Arrays;

/**
 * @author Joe
 * TODO description
 * 2021/8/6 22:02
 */
public class Heap {
    private int[] a; // array to store heap
    private int n; // array max size
    private int count; // current stored size

    public Heap(int capacity) {
        a = new int[capacity + 1]; // index 0 is empty
        n = capacity;
    }

    @Override
    public String toString() {
        return Arrays.toString(a);
    }

    public void insert(int data) {
        if (count >= n) {
            // heap is full
            return;
        }
        ++count;
        a[count] = data;
        // heapify
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            // from bottom to top
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    public void removeTop() {
        if (count == 0) {
            return;
        }
        // put last to the top
        // remove top
        a[1] = a[count];
        --count;
        // re-heapify the n-1 heap
        heapify(a, count, 1);
    }

    /**
     * build heap from top to bottom
     * @param a array
     * @param n heap size
     */
    public static void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; i--) {
            // from the last non-leaf node
            heapify(a, n, i);
        }
    }

    /**
     * heap sort
     * @param a
     * @param n
     */
    public static void sort(int[] a,int n) {
        buildHeap(a, n);
        // use from the last position
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            k--;
            heapify(a, k, 1);
        }
    }

    /**
     * from top to bottom
     * @param a
     * @param n heap size
     * @param i index
     */
    private static void heapify(int[] a, int n, int i) {
        while(true) {
            // maxPos is the max number in the child tree whose root is i
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                // compare with left child
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1; // 左子节点和右子节点比较
            }
            if (maxPos == i) {
                // 无法再堆化，直接停止
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    public int getTop() {
        return a[1];
    }

    public int[] getArray() {
        // move the position
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = a[i + 1];
        }
        return array;
    }

    /**
     * swap two values
     * @param a
     * @param i
     * @param j
     */
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
