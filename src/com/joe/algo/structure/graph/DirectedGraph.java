package com.joe.algo.structure.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Joe
 * 有向图
 * 2021/9/2 20:09
 */
public class DirectedGraph {
    public int v; // 顶点个数
    public List<Integer>[] adj; // 邻接表

    public DirectedGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * s -> t 说明s先于t执行
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
    }
}
