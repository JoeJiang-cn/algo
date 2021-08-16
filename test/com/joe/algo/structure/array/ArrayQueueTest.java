package com.joe.algo.structure.array;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ArrayQueueTest extends TestCase {

    @Test
    public void testEnqueue() {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(10);
        queue.enqueue(16);
        Assert.assertTrue(queue.enqueue(30));
        Assert.assertFalse(queue.enqueue(50));
    }

    @Test
    public void testDequeue() {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(10);
        Assert.assertEquals(queue.dequeue(), 3);
        Assert.assertEquals(queue.dequeue(), 7);
        Assert.assertEquals(queue.dequeue(), 10);
        Assert.assertEquals(queue.dequeue(), -1);
    }
}