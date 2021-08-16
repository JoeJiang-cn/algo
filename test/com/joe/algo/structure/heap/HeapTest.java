package com.joe.algo.structure.heap;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {

    @Test
    public void testInsert() {
        int[] a = {3, 5, 8, 6, 10, 16, 12, 33, 20};
        Heap heap = new Heap(a.length);
        for (int data : a) {
            heap.insert(data);
        }
        Assert.assertEquals(heap.getTop(), 33);
    }

    @Test
    public void testRemoveTop() {
        int[] a = {3, 5, 8, 6, 10, 16, 12, 33, 20};
        Heap heap = new Heap(a.length);
        for (int data : a) {
            heap.insert(data);
        }
        heap.removeTop();
        Assert.assertEquals(heap.getTop(), 20);
    }

    @Test
    public void testBuildHeap() {
        int[] a = {0, 3, 5, 8, 6, 10, 16, 12, 33, 20}; // 0 is a place holder
        Heap.buildHeap(a, a.length - 1);
        Assert.assertEquals(a[1], 33);
    }

    @Test
    public void testHeapSort() {
        int[] a = {0, 3, 5, 8, 6, 10, 16, 12, 33, 20};
        Heap.sort(a, a.length - 1);
        Assert.assertArrayEquals(a, new int[]{0, 3, 5, 6, 8, 10, 12, 16, 20, 33});
    }
}