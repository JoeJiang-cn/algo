package com.joe.algo.structure.graph;

import java.util.LinkedList;

/**
 * @author Joe
 * 无向图
 * 2021/9/2 20:01
 */
public class UndirectedGraph {
    public int v; // 顶点的个数
    public LinkedList<Integer>[] adj; // 邻接表

    public UndirectedGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }
}
