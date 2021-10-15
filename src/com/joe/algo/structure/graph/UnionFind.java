package com.joe.algo.structure.graph;

/**
 * @author Joe
 * TODO description
 * 2021/9/26 9:13
 */
public class UnionFind {
    // 连通量
    private int count;
    // 存储一棵树，只保存每个节点的父节点
    private int[] parent;
    // 记录树的规模
    private int[] size;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            // 根节点的父节点指向自己
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * 连接p和q所在的树
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            // 已连通
            return;
        }
        if (size[rootP] > size[rootQ]) {
            // 把小树接在大树后
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    /**
     * 判断p和q是不是连通的
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    /**
     * 找节点x的根节点
     * @param x
     * @return
     */
    private int find(int x) {
        while (parent[x] != x) { // 循环一直到根节点
            // 路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
