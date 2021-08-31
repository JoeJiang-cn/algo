package com.joe.algo.structure;

public class LRUCache {
    private int[] hashArray;
    private int[] visited;
    private int count = 0;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashArray = new int[10001];
        for (int i = 0; i <= 10000; i++) {
            hashArray[i] = -1;
        }
        visited = new int[capacity];
    }

    public int get(int key) {
        shift(key);
        return hashArray[key];
    }

    /**
     * 1、修改
     * 2、新增，有空位
     * 3、新增，无空位
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (hashArray[key] != -1) {
            // 修改
            shift(key);
        } else {
            // 新增
            if (count < capacity) {
                // 有空位
                count++;
            } else {
                // 没空位
                hashArray[visited[0]] = -1;
                shift(visited[0]);
            }
            visited[count - 1] = key;
        }
        hashArray[key] = value;
    }

    private void shift(int key) {
        // 调整先后顺序 visited[0]代表最少访问的
        int i = 0;
        for (; i < count; i++) {
            if (key == visited[i]) {
                // 找到位置
                break;
            }
        }
        if (i < count) {
            // 搬移i到最后，其他依次往前
            int temp = visited[i];
            for (int j = i; j < count - 1; j++) {
                visited[j] = visited[j + 1];
            }
            visited[count - 1] = temp;
        }
    }
}
