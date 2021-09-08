package com.joe.algo.structure.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestPathTest {

    @Test
    public void testDijkstra() {
        ShortestPath shortestPath = new ShortestPath(6);
        shortestPath.addEdge(0, 1, 10);
        shortestPath.addEdge(0, 4, 15);
        shortestPath.addEdge(1, 3, 2);
        shortestPath.addEdge(1, 2, 15);
        shortestPath.addEdge(2, 5,5);
        shortestPath.addEdge(3, 2, 1);
        shortestPath.addEdge(3, 5, 12);
        shortestPath.addEdge(4, 5, 10);
        shortestPath.dijkstra(0, 5);
    }
}