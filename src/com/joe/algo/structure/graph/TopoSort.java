package com.joe.algo.structure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Joe
 * TODO description
 * 2021/9/2 20:17
 */
public class TopoSort {
    private DirectedGraph graph;

    public TopoSort(DirectedGraph graph) {
        this.graph = graph;
    }

    /**
     * Kahn算法
     */
    public void topoSortByKahn() {
        // 求入度
        int[] inDegree = new int[graph.v];
        for (int i = 0; i < graph.v; i++) {
            for (int w : graph.adj[i]) {
                inDegree[w]++;
            }
        }
        // 队列处理所有入度为0的顶点，处理完出队
        Queue<Integer> queue = new LinkedList<>();
        // 要是队列起始为空，说明没有一个顶点入度为0，有循环依赖
        for (int i = 0; i < graph.v; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print("->" + node);
            for (int w : graph.adj[node]) {
                inDegree[w]--;
                if (inDegree[w] == 0) {
                    queue.offer(w);
                }
            }
        }
    }
}
