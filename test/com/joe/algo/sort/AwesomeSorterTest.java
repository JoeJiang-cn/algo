package com.joe.algo.sort;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* AwesomeSorter Tester. 
* 
* @author <Authors name> 
* @since <pre>7月 23, 2021</pre> 
* @version 1.0 
*/ 
public class AwesomeSorterTest {
    private AwesomeSorter sorter;

    @Before
    public void setUp() throws Exception {
        sorter = new AwesomeSorter();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
    *
    * Method: bubbleSort(int[] array)
    *
    */
    @Test
    public void testBubbleSort() throws Exception {
        int[] array = {3, 3, 5, 4, 1, 2, 6};
        int[] sortedArray = {1, 2, 3, 3, 4, 5, 6};
        sorter.bubbleSort(array);
        Assert.assertArrayEquals(array, sortedArray);
    }

    /**
    *
    * Method: insertionSort(int[] array)
    *
    */
    @Test
    public void testInsertionSort() throws Exception {
        int[] array = {3, 3, 5, 4, 1, 2, 6};
        int[] sortedArray = {1, 2, 3, 3, 4, 5, 6};
        sorter.bubbleSort(array);
        Assert.assertArrayEquals(array, sortedArray);
    }

    /**
    *
    * Method: selectionSort(int[] array)
    *
    */
    @Test
    public void testSelectionSort() throws Exception {
        int[] array = {3, 3, 5, 4, 1, 2, 6};
        int[] sortedArray = {1, 2, 3, 3, 4, 5, 6};
        sorter.bubbleSort(array);
        Assert.assertArrayEquals(array, sortedArray);
    }

    /**
    *
    * Method: mergeSort(int[] array)
    *
    */
    @Test
    public void testMergeSort() throws Exception {
        int[] array = {3, 3, 5, 4, 1, 2, 6};
        int[] sortedArray = {1, 2, 3, 3, 4, 5, 6};
        sorter.bubbleSort(array);
        Assert.assertArrayEquals(array, sortedArray);
    }

    @Test
    public void testQuickSort() {
        int[] array = {3, 3, 5, 4, 1, 2, 6};
        int[] sortedArray = {1, 2, 3, 3, 4, 5, 6};
        sorter.quickSort(array);
        Assert.assertArrayEquals(array, sortedArray);
    }

    @Test
    public void testCountSort() {
        int[] array = {2, 5, 3, 0, 2, 3, 0, 3};
        int[] sortedArray = {0, 0, 2, 2, 3, 3, 3, 5};
        sorter.countSort(array, 6);
        Assert.assertArrayEquals(array, sortedArray);
    }

} 
