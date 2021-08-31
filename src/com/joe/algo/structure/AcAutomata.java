package com.joe.algo.structure;

import java.util.LinkedList;
import java.util.Queue;

public class AcAutomata {

    private AcNode root;

    public AcAutomata() {
        root = new AcNode('/');
    }

    /**
     * 插入一个字符串到Trie树
     * @param text
     */
    public void insert(String text) {
        char[] chars = text.toCharArray();
        AcNode p = root;
        int i = 0;
        for (; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (p.children[index] == null) {
                // add
                AcNode newNode = new AcNode(chars[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEnding = true;
        p.length = i;
    }

    public AcAutomata deriveInsert(String text) {
        insert(text);
        return this;
    }

    /**
     * 构建失败指针
     */
    public void buildFailurePointer() {
        Queue<AcNode> queue = new LinkedList<>();
        root.fail = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            AcNode p = queue.remove();
            for (int i = 0; i < 26; i++) {
                // p的子节点pc
                AcNode pc = p.children[i];
                if (pc == null) {
                    continue;
                }
                if (p == root) {
                    // 设置第一层子节点的失败指针指向root
                    pc.fail = root;
                } else {
                    AcNode q = p.fail;
                    while (q != null) {
                        // 求q的子节点，是不是和pc相等
                        AcNode qc = q.children[pc.data - 'a'];
                        if (qc != null) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }

    public void match(char[] text) {
        int n = text.length;
        AcNode p = root;
        for (int i = 0; i < n; i++) {
            int idx = text[i] - 'a';
            while (p.children[idx] == null && p!= root) {
                // 匹配失败，跳转到失败指针
                p = p.fail;
            }
            p = p.children[idx];
            if (p == null) {
                // 如果没有匹配的，从root开始重新匹配
                p = root;
            }
            AcNode tmp = p;
            while (tmp != root) {
                if (tmp.isEnding) {
                    int pos = i - tmp.length + 1;
                    System.out.println("匹配起始下标" + pos + "；长度" + tmp.length);
                }
                // 匹配其他模式串的前缀子串
                tmp = tmp.fail;
            }
        }
    }

    private class AcNode {
        public char data;
        public AcNode[] children = new AcNode[26]; // 字符集只包含a~z这26个字符
        public boolean isEnding = false; // 结尾字符为true
        public int length = -1; // 当isEndingChar=true时，记录模式串长度
        public AcNode fail; // 失败指针
        public AcNode(char data) {
            this.data = data;
        }
    }
}
