package com.joe.algo.structure.graph;

import java.util.LinkedList;

/**
 * @author Joe
 * TODO description
 * 2021/9/3 18:01
 */
public class ShortestPath {

    private int v;
    private LinkedList<Edge>[] adj;

    public ShortestPath(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) {
        adj[s].add(new Edge(s, t, w));
    }

    /**
     * 求从s到t的最短路径
     * @param s
     * @param t
     */
    public void dijkstra(int s, int t) {
        // 用来还原最短路径
        int[] predecessor = new int[v];
        Vertex[] vertices = new Vertex[v];
        for (int i = 0; i < v; i++) {
            // 初始化顶点数组
            vertices[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        PriorityQueue queue = new PriorityQueue(v);
        // 标记是否进入过队列，防止重复加入队列
        boolean[] inQueue = new boolean[v];
        // 初始化起点
        vertices[s].dist = 0;
        queue.add(vertices[s]);
        inQueue[s] = true;

        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll();
            if (minVertex.id == t) {
                break;
            }
            for (int i = 0; i < adj[minVertex.id].size(); i++) {
                // 遍历当前顶点的所有边
                Edge e = adj[minVertex.id].get(i);
                // 获取相邻顶点
                Vertex nextVertex = vertices[e.tid];
                if (minVertex.dist + e.w < nextVertex.dist) {
                    // 更新距离
                    nextVertex.dist = minVertex.dist + e.w;
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inQueue[nextVertex.id]) {
                        // 更新在队列中的顶点
                        queue.update(nextVertex);
                    } else {
                        // 添加到队列中
                        queue.add(nextVertex);
                        inQueue[nextVertex.id] = true;
                    }
                }
            }
        }
        System.out.print(s);
        print(s, t, predecessor);
    }

    private void print(int s, int t, int[] predecessor) {
        if (s == t) {
            return;
        }
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }

    private class Edge {
        // 起始顶点
        public int sid;
        // 终止顶点
        public int tid;
        // 权重
        public int w;

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    /**
     * 小顶堆
     */
    private class PriorityQueue {
        private Vertex[] nodes;
        private int capacity;
        private int count = 0;

        public PriorityQueue(int v) {
            this.nodes = new Vertex[v + 1];
            this.capacity = v;
        }

        public Vertex poll() {
            if (count == 0) {
                return null;
            }
            Vertex top = nodes[1];
            // put last to the top
            // remove top
            nodes[1] = nodes[count];
            --count;
            // re-heapify the n-1 heap
            heapify(count, 1);
            return top;
        }

        public void add(Vertex vertex) {
            if (count >= capacity) {
                // heap is full
                return;
            }
            ++count;
            nodes[count] = vertex;
            // heapify
            int i = count;
            while (i / 2 > 0 && nodes[i].dist < nodes[i / 2].dist) {
                // from bottom to top
                swap(i, i / 2);
                i = i / 2;
            }
        }

        /**
         * 更新对应顶点的值
         * @param vertex
         */
        public void update(Vertex vertex) {
            if (isEmpty()) {
                return;
            }
            for (int i = 1; i < count; i++) {
                if (nodes[i].id == vertex.id) {
                    nodes[i].dist = vertex.dist;
                }
            }
        }

        public boolean isEmpty() {
            return count == 0;
        }

        private void swap(int i, int j) {
            Vertex temp = nodes[i];
            nodes[i] = nodes[j];
            nodes[j] = temp;
        }

        private void heapify(int n, int i) {
            while(true) {
                int maxPos = i;
                if (i * 2 <= n && nodes[i].dist > nodes[i * 2].dist) {
                    maxPos = i * 2;
                }
                if (i * 2 + 1 <= n && nodes[maxPos].dist > nodes[i * 2 + 1].dist) {
                    maxPos = i * 2 + 1;
                }
                if (maxPos == i) {
                    break;
                }
                swap(i, maxPos);
                i = maxPos;
            }
        }
    }

    private class Vertex {
        public int id;
        public int dist;
        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }
}
