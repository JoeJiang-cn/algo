package com.joe.algo.structure.heap;

/**
 * @author Joe
 * TODO description
 * 2021/8/14 16:19
 */
public class HeapApp {

    /**
     * 由小到大排序，求前K个最小的数
     * @param a
     * @param k
     * @return
     */
    public int[] calculateTopKAsc(int[] a, int k) {
        int n = a.length;
        if (k > n) {
            return null;
        }
        // 构建k容量的大顶堆，heap内数组长度k+1
        Heap heap = new Heap(k);
        for (int i = 0; i < k; i++) {
            heap.insert(a[i]);
        }

        for (int i = k; i < n; i++) {
            if (a[i] < heap.getTop()) {
                heap.removeTop();
                heap.insert(a[i]);
            }
        }

        return heap.getArray();
    }

}
