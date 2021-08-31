package com.joe.algo.structure;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('/');
    }

    /**
     * 插入一个字符串到Trie树
     * @param text
     */
    public void insert(String text) {
        char[] chars = text.toCharArray();
        TrieNode p = root;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (p.children[index] == null) {
                // add
                TrieNode newNode = new TrieNode(chars[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEnding = true;
    }

    public Trie deriveInsert(String text) {
        insert(text);
        return this;
    }

    /**
     * 是否完整匹配
     * @param text
     * @return
     */
    public boolean perfectMatch(String text) {
        char[] chars = text.toCharArray();
        TrieNode p = root;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (p.children[index] == null) {
                // 不匹配，提前退出
                return false;
            }
            p = p.children[index];
        }
        return p.isEnding;
    }

    /**
     * 前缀是否匹配
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode p = root;
        int i = 0;
        for (; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (p.children[index] == null) {
                break;
            }
            p = p.children[index];
        }
        return i == chars.length;
    }

    private class TrieNode {
        private char data;
        // 只包含小写字母
        private TrieNode[] children = new TrieNode[26];
        // 表示是否为字符串终点
        private boolean isEnding;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
