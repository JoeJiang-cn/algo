package com.joe.algo.backtrack;

/**
 * @author Joe
 * 0-1背包问题的回溯解法
 * 2021/8/28 20:36
 */
public class Knapsack {
    private int maxW = Integer.MIN_VALUE;
    // 物品重量数组
    private int[] weight;
    // 物品个数
    private int n;
    // 背包总重量
    private int w;
    // 备忘录
    private boolean[][] mem;

    public Knapsack(int[] weight, int n, int w, boolean[][] mem) {
        this.weight = weight;
        this.n = n;
        this.w = w;
        this.mem = mem;
    }

    public void f(int i, int cw) {
        if (cw == w || i == n) {
            // 递归树不用再往下递归，或者已经递归到叶子节点
            // 放满了，或者选择到最后一个
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        if (mem[i][cw]) {
            return;
        }
        mem[i][cw] = true;
        // 下面对应递归树的两种选择：放或不放
        // 不放
        f(i + 1, cw);
        if (cw + weight[i] <= w) {
            // 可以放得下，选择放
            f(i + 1, cw + weight[i]);
        }
    }

    public int getMaxW() {
        return maxW;
    }
}
