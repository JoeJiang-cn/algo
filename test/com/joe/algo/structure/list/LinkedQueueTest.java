package com.joe.algo.structure.list;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class LinkedQueueTest extends TestCase {

    @Test
    public void testEnqueue() {

    }

    @Test
    public void testDequeue() {
        LinkedQueue queue = new LinkedQueue(5);
        queue.enqueue(8);
        Assert.assertEquals(queue.dequeue().value, 5);
        queue.enqueue(12);
        Assert.assertEquals(queue.dequeue().value, 8);
    }
}