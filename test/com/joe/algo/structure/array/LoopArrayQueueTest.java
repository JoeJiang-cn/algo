package com.joe.algo.structure.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoopArrayQueueTest {

    @Test
    public void testEnqueue() {
        LoopArrayQueue queue = new LoopArrayQueue(5);
        queue.enqueue(5);
        queue.enqueue(8);
        queue.enqueue(10);
        queue.enqueue(13);
        queue.enqueue(15);
        Assert.assertFalse(queue.enqueue(20));
    }

    @Test
    public void testDequeue() {
        LoopArrayQueue queue = new LoopArrayQueue(5);
        queue.enqueue(5);
        queue.enqueue(8);
        queue.enqueue(10);
        Assert.assertEquals(queue.dequeue(), 5);
        Assert.assertEquals(queue.dequeue(), 8);
        queue.enqueue(13);
        queue.enqueue(15);
        Assert.assertEquals(queue.dequeue(), 10);
        queue.enqueue(20);
        Assert.assertEquals(queue.dequeue(), 13);
        Assert.assertEquals(queue.dequeue(), 15);
        Assert.assertEquals(queue.dequeue(), 20);
        Assert.assertEquals(queue.dequeue(), -1);
    }
}