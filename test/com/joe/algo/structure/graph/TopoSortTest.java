package com.joe.algo.structure.graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TopoSortTest {
    private DirectedGraph graph;

    @Before
    public void setUp() {
        graph = new DirectedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(1, 5);
        graph.addEdge(4, 5);
    }

    @Test
    public void testTopoSortByKahn() {
        TopoSort topoSort = new TopoSort(graph);
        topoSort.topoSortByKahn();
    }
}