package com.joe.algo.string;

public class StringMatch {
    private static final int SIZE = 256;

    /**
     * BF算法
     * @param main 主串
     * @param n 主串长度
     * @param pattern 模式串
     * @param m 模式串长度
     * @return
     */
    public static int bruteForce(char[] main, int n, char[] pattern, int m) {
        if (n < m) {
            return -1;
        }
        int i = 0;
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; j--) {
                if (main[i + j] != pattern[j]) {
                    break;
                }
            }
            if (j < 0) {
                // 匹配成功
                return i;
            }
            // 没找到
            i++;
        }
        return -1;
    }

    /**
     * RK算法，利用哈希算法
     * @param main
     * @param n
     * @param pattern
     * @param m
     * @return
     */
    public static int RK(char[] main, int n, char[] pattern, int m) {
        // 计算模式串的Hash
        int patternHash = 0;
        for (int i = 0; i < m; i++) {
            patternHash += pattern[i];
        }

        int[] hash = new int[n - m + 1];
        int currentHash = 0;
        for (int i = 0; i < n - m + 1; i++) {
            if (i == 0) {
                // 计算第一个M长度的Hash
                for (int j = 0; j < m; j++) {
                    currentHash += main[j];
                }
            } else {
                currentHash = currentHash - main[i - 1] + main[i + m - 1];
            }
            hash[i] = currentHash;
        }

        for (int i = 0; i < n - m; i++) {
            if (hash[i] == patternHash) {
                boolean found = true;
                for (int j = 0; j < m; j++) {
                    if (pattern[j] != main[i + j]) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * BM算法，坏字符和好后缀滑动较远的
     * @param main
     * @param n
     * @param pattern
     * @param m
     * @return
     */
    public static int BM(char[] main, int n, char[] pattern, int m) {
        int[] bc = new int[SIZE];
        generateBC(pattern, m, bc);
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(pattern, m, suffix, prefix);
        int i = 0;
        while (i <= n - m) {
            // 坏字符在模式串中对应的位置
            int j;
            for (j = m - 1; j >= 0; j--) {
                if (main[i + j] != pattern[j]) {
                    break;
                }
            }
            if (j < 0) {
                // 匹配成功
                return i;
            }
            // 好后缀的作用是在这里
            // 坏字符返回 i = i + (j - bc[main[i + j]]);
            int x = j - bc[main[i + j]];
            int y = 0;
            if (j < m - 1) {
                // 计算好后缀
                y = moveByGS(j, m, suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    /**
     * 坏字符在模式串中的位置
     * @param pattern
     * @param m
     * @param bc
     */
    private static void generateBC(char[] pattern, int m, int[] bc) {
        for (int i = 0; i < SIZE; i++) {
            // 初始化
            bc[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            int ascii = pattern[i];
            bc[ascii] = i;
        }
    }

    /**
     * 好后缀预处理
     * @param pattern
     * @param m
     * @param suffix
     * @param prefix
     */
    private static void generateGS(char[] pattern, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; i++) {
            int j = i;
            // 公共后缀子串长度
            int k = 0;
            // pattern[j] [0~j]
            // pattern[m-1-k] [m-1-k-j, m-1-k]
            while (j >= 0 && pattern[j] == pattern[m - 1 - k]) {
                j--;
                k++;
                suffix[k] = j + 1; // j+1表示公共后缀子串在pattern[0,i]中的起始下标
            }
            if (j == -1) {
                // 如果公共后缀子串也是模式串的前缀子串
                prefix[k] = true;
            }
        }
    }

    /**
     * 好后缀规则移动的位数
     * @param j
     * @param m
     * @param suffix
     * @param prefix
     * @return
     */
    private static int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        // 好后缀长度
        int k = m - 1 - j;
        if (suffix[k] != -1) {
            // 好后缀整个匹配于模式串中的某个位置
            return j - suffix[k] + 1;
        }
        // 看下好后缀的后缀子串，和模式串的前缀子串，有没有匹配关系
        for (int r = j + 2; r <= m - 1; r++) {
            // m - r 是后缀子串的长度
            if (prefix[m - r]) {
                return r;
            }
        }
        return m;
    }

    /**
     * KMP算法
     * BM是模式串从后往前匹配，KMP是模式串从前往后匹配
     * @param main
     * @param n
     * @param pattern
     * @param m
     * @return
     */
    public static int KMP(char[] main, int n, char[] pattern, int m) {
        int[] next = getNext(pattern, m);
        // j 坏字符位置
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && main[i] != pattern[j]) {
                // next[j - 1]好前缀的后缀 和 模式串的前缀 匹配的位置
                j = next[j - 1] + 1;
            }
            if (main[i] == pattern[j]) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    private static int[] getNext(char[] pattern, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; i++) {
            while (k != -1 && (pattern[k + 1] != pattern[i])) {
                k = next[k];
            }
            if (pattern[k + 1] == pattern[i]) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }
}
