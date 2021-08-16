package com.joe.algo.structure.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeapAppTest {
    private HeapApp heapApp;

    @Before
    public void setUp() {
        heapApp = new HeapApp();
    }

    @Test
    public void testCalculateTopKAsc() {
        int[] a = {27, 18, 11, 29, 5, 30, 15, 14};
        Assert.assertArrayEquals(heapApp.calculateTopKAsc(a, 2), new int[] {11, 5});
    }
}