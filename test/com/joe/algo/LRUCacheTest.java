package com.joe.algo;

import com.joe.algo.structure.LRUCache;
import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void testLRUCache() {
//        LRUCache lruCache = new LRUCache(10);
//        lruCache.put(10, 13);
//        lruCache.put(3, 17);
//        lruCache.put(6, 11);
//        lruCache.put(10, 5);
//        lruCache.put(9, 10);
//        Assert.assertEquals(lruCache.get(13), -1);
//        lruCache.put(2, 19);
//        Assert.assertEquals(lruCache.get(2), 19);
//        Assert.assertEquals(lruCache.get(3), 17);
//        lruCache.put(5, 25);
//        Assert.assertEquals(lruCache.get(8), -1);
//        lruCache.put(9, 22);
//        lruCache.put(5, 5);
//        lruCache.put(1, 30);
//        Assert.assertEquals(lruCache.get(11), -1);
//        lruCache.put(9, 12);
//        Assert.assertEquals(lruCache.get(7), -1);
//        Assert.assertEquals(lruCache.get(5), 5);
//        Assert.assertEquals(lruCache.get(8), -1);
//        Assert.assertEquals(lruCache.get(9), 12);
//        lruCache.put(4, 30);
//        lruCache.put(9, 3);
//        Assert.assertEquals(lruCache.get(9), 3);
//        Assert.assertEquals(lruCache.get(10), 5);
//        Assert.assertEquals(lruCache.get(10), 5);
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        Assert.assertEquals(lruCache.get(2), -1);
    }

}