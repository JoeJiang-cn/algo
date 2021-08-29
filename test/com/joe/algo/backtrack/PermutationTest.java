package com.joe.algo.backtrack;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PermutationTest {

    @Test
    public void testSolve() {
        Permutation permutation = new Permutation();
        Assert.assertEquals(permutation.solve(new int[]{1, 2, 3, 4}), 24);
    }
}