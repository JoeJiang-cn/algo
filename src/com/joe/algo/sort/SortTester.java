package com.joe.algo.sort;

import java.util.Arrays;

/**
 * @author Joe
 * TODO description
 * 2021/7/18 16:01
 */
public class SortTester {
    public static void main(String[] args) {
        int[] array = {3, 5, 4, 1, 2, 6};
        new AwesomeSorter().mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
