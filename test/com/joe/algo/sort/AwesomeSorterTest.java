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
    private int[] array;
    private int[] sortedArray;
    private AwesomeSorter sorter;

    @Before
    public void before() throws Exception {
        array = new int[]{3, 3, 5, 4, 1, 2, 6};
        sortedArray = new int[]{1, 2, 3, 3, 4, 5, 6};
        sorter = new AwesomeSorter();
    }

    @After
    public void after() throws Exception {
        // 恢复
        array = new int[]{3, 5, 4, 1, 2, 6};
    }

    /**
    *
    * Method: bubbleSort(int[] array)
    *
    */
    @Test
    public void testBubbleSort() throws Exception {
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
        sorter.bubbleSort(array);
        Assert.assertArrayEquals(array, sortedArray);
    }

    @Test
    public void testQuickSort() {
        sorter.quickSort(array);
        Assert.assertArrayEquals(array, sortedArray);
    }

} 
