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
    public void testSearchFirstEqual() {
        int[] array = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        Assert.assertEquals(binarySearch.searchFirstEqual(array, 8), 5);
    }

    @Test
    public void testSearchLastEqual() {
        int[] array = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        Assert.assertEquals(binarySearch.searchLastEqual(array, 8), 7);
    }

    @Test
    public void testSearchFirstGE() {
        int[] array = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        Assert.assertEquals(binarySearch.searchFirstGE(array, 2), 1);
        Assert.assertEquals(binarySearch.searchFirstGE(array, 20), -1);
    }

    @Test
    public void testSearchLastLE() {
        int[] array = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        Assert.assertEquals(binarySearch.searchLastLE(array, 7), 4);
        Assert.assertEquals(binarySearch.searchLastLE(array, 8), 5);
    }
}