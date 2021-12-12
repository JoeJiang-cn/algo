package com.joe.algo.structure;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DifferenceTest {

    @Test
    public void result() {
        int[] nums = {1, 2, 3};
        Difference difference = new Difference(nums);
        difference.increment(1, 1, 3);
        Assert.assertArrayEquals(difference.result(), new int[]{1, 5, 3});
        difference.increment(1, 2, -1);
        Assert.assertArrayEquals(difference.result(), new int[]{1, 4, 2});
    }
}