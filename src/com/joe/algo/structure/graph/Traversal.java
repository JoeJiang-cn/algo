package com.joe.algo.structure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Joe
 * 基于无向图的广度优先和深度优先遍历
 * 2021/9/2 20:02
 */
public class Traversal {
    private UndirectedGraph graph;
    private boolean found = false; // dfs

    public Traversal(UndirectedGraph graph) {
        this.graph = graph;
    }

    /**
     * 广度优先打印s->t的路径，即最短路径
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[graph.v];
        visited[s] = true;
        int[] prev = new int[graph.v];
        for (int i = 0; i < graph.v; i++) {
            prev[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph.adj[node]) {
                if (!visited[next]) {
                    prev[next] = node;
                    if (next == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

    /**
     * 深度优先打印s->t的路径
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        boolean[] visited = new boolean[graph.v];
        visited[s] = true;
        int[] prev = new int[graph.v];
        for (int i = 0; i < graph.v; i++) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int current, int t, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }
        if (current == t) {
            found = true;
            return;
        }
        for (int next : graph.adj[current]) {
            if (!visited[next]) {
                prev[next] = current;
                visited[next] = true;
                recurDfs(next, t, visited, prev);
            }
        }
    }

    /**
     * 递归打印
     * @param prev
     * @param s
     * @param t
     */
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && s != t) {
            // 退出条件就是追溯到起点的时候
            print(prev, s, prev[t]);
        }
        System.out.print("->" + t);
    }
}