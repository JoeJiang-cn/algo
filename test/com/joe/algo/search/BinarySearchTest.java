package com.joe.algo.search;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {
    private BinarySearch binarySearch;

    @Before
    public void setUp() {
        binarySearch = new BinarySearch();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSearchInUniqArray() {
        int[] array = {1, 4, 5, 6, 9, 10, 13};
        Assert.assertEquals(binarySearch.searchInUniqArray(array, 10), 5);
        Assert.assertEquals(binarySearch.searchInUniqArray(array, 3), -1);
    }

    @Test
    public void testRecursivelySearchInUniqArray() {
        int[] array = {1, 4, 5, 6, 9, 10, 13};
        Assert.assertEquals(binarySearch.recursivelySearchInUniqArray(array, 10), 5);
        Assert.assertEquals(binarySearch.recursivelySearchInUniqArray(array, 3), -1);
    }

    @Test
    public void testSearchMostLeft() {
        int[] array = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        Assert.assertEquals(binarySearch.searchMostLeft(array, 8), 5);
    }
}