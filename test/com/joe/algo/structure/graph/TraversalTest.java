package com.joe.algo.structure.graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TraversalTest {
    private UndirectedGraph graph;

    /**
     * 0 - 1 - 2
     * |   |   |
     * 3 - 4 - 5
     *     |   |
     *     6 - 7
     */
    @Before
    public void setUp() {
        graph = new UndirectedGraph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
    }

    @Test
    public void testBfs() {
        // 0 1 4 6
        Traversal traversal = new Traversal(graph);
        traversal.bfs(0, 6);
    }

    @Test
    public void testDfs() {
        // 0 1 2 5 4 6
        Traversal traversal = new Traversal(graph);
        traversal.dfs(0, 6);
    }
}