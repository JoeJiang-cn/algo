package com.joe.algo.string;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringMatchTest {

    @Test
    public void testBruteForce() {
        char[] main = {'a', 'b', 'a', 'b', 'b', 'a'};
        char[] pattern1 = {'a', 'b', 'b'};
        char[] pattern2 = {'b', 'a'};
        char[] pattern3 = {'c', 'b'};
        Assert.assertEquals(StringMatch.bruteForce(main, 6, pattern1, 3), 2);
        Assert.assertEquals(StringMatch.bruteForce(main, 6, pattern2, 2), 1);
        Assert.assertEquals(StringMatch.bruteForce(main, 6, pattern3, 2), -1);
    }

    @Test
    public void testRK() {
        char[] main = {'a', 'b', 'a', 'b', 'b', 'a'};
        char[] pattern1 = {'a', 'b', 'b'};
        char[] pattern2 = {'b', 'a'};
        char[] pattern3 = {'c', 'b'};
        Assert.assertEquals(StringMatch.RK(main, 6, pattern1, 3), 2);
        Assert.assertEquals(StringMatch.RK(main, 6, pattern2, 2), 1);
        Assert.assertEquals(StringMatch.RK(main, 6, pattern3, 2), -1);
    }

    @Test
    public void testBM() {
        char[] main = {'a', 'b', 'a', 'b', 'b', 'a'};
        char[] pattern1 = {'a', 'b', 'b'};
        char[] pattern2 = {'b', 'a'};
        char[] pattern3 = {'c', 'b'};
        Assert.assertEquals(StringMatch.BM(main, 6, pattern1, 3), 2);
        Assert.assertEquals(StringMatch.BM(main, 6, pattern2, 2), 1);
        Assert.assertEquals(StringMatch.BM(main, 6, pattern3, 2), -1);
    }

    @Test
    public void testKMP() {
        char[] main = {'a', 'b', 'a', 'b', 'b', 'a'};
        char[] pattern1 = {'a', 'b', 'b'};
        char[] pattern2 = {'b', 'a'};
        char[] pattern3 = {'c', 'b'};
        Assert.assertEquals(StringMatch.KMP(main, 6, pattern1, 3), 2);
        Assert.assertEquals(StringMatch.KMP(main, 6, pattern2, 2), 1);
        Assert.assertEquals(StringMatch.KMP(main, 6, pattern3, 2), -1);
    }
}