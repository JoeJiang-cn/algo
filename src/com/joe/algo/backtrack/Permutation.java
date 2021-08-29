package com.joe.algo.backtrack;

import java.util.Arrays;

/**
 * @author Joe
 * 全排列
 * 2021/8/28 20:36
 */
public class Permutation {
    // 全排列个数
    private int result;

    /**
     * array:[1,2,3,4,5]...
     * @param array
     */
    public int solve(int[] array) {
        calculate(array, 0);
        return result;
    }

    private void calculate(int[] array, int level) {
        if (level == array.length) {
            // 遍历结束，打印
            System.out.println(Arrays.toString(array));
            result++;
            return;
        }
        for (int i = level; i < array.length; i++) {
            swap(array, level, i);
            calculate(array, level + 1);
            swap(array, level, i);
        }
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
