package com.joe.algo.backtrack;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class KnapsackTest {

    @Test
    public void testF() {
        Knapsack knapsack = new Knapsack(
                new int[] {2, 2, 4, 6, 3},
                5,
                9,
                new boolean[5][10]
        );
        // f(0,0)为递归树的根
        knapsack.f(0, 0);
        Assert.assertEquals(knapsack.getMaxW(), 9);
    }
}