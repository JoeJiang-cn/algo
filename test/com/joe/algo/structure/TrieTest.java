package com.joe.algo.structure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrieTest {
    Trie trie;

    @Before
    public void setUp() {
        trie = new Trie();
        trie.deriveInsert("hello")
                .deriveInsert("her")
                .deriveInsert("happy")
                .deriveInsert("world")
                .deriveInsert("word");
    }

    @Test
    public void testPerfectMatch() {
        Assert.assertTrue(trie.perfectMatch("her"));
        Assert.assertTrue(trie.perfectMatch("word"));
        Assert.assertFalse(trie.perfectMatch("wo"));
    }

    @Test
    public void testIsPrefix() {
        Assert.assertTrue(trie.isPrefix("her"));
        Assert.assertTrue(trie.isPrefix("he"));
        Assert.assertFalse(trie.isPrefix("wocao"));
    }
}