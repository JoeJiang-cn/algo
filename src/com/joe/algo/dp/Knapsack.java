package com.joe.algo.dp;

/**
 * @author Joe
 * 0-1背包问题的动态规划解法
 * 2021/8/28 20:36
 */
public class Knapsack {
    /**
     *
     * @param items 物品数组
     * @param n 物品个数
     * @param w 不能超过多少重量
     * @return 求最大可放的重量
     */
    public int knapsackMaxWeight(int[] items, int n, int w) {
        // 默认为false，存放包中0~W重量是否有状态能达到
        boolean[] states = new boolean[w + 1];
        states[0] = true;
        if (items[0] <= w) {
            states[items[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = w - items[i]; j >= 0; j--) {
                // 包的剩余容量
                if (states[j]) {
                    states[j + items[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; i--) {
            // 找最大的i
            if (states[i]) {
                return i;
            }
        }
        return 0;
    }
}
