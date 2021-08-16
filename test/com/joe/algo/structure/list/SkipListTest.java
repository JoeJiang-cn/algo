package com.joe.algo.structure.list;

import com.joe.algo.structure.list.SkipList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SkipListTest {
    private SkipList list;

    @Before
    public void setUp() {
        list = new SkipList();
    }

    @After
    public void tearDown() {
        list = null;
    }

    @Test
    public void testSearch() {
        list.insert(10);
        list.insert(20);
        SkipList.Node node = list.search(10);
        Assert.assertEquals(node.data, 10);
    }

    @Test
    public void testRemove() {
        list.insert(10);
        list.insert(20);
        list.remove(10);
        SkipList.Node node = list.search(10);
        Assert.assertNull(node);
    }

}