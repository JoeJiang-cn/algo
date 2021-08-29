package com.joe.algo.backtrack;

import org.junit.Test;

import static org.junit.Assert.*;

public class NQueenTest {

    @Test
    public void testSolve() {
        NQueen nQueen = new NQueen();
        nQueen.solve(0, new int[6]);
    }
}