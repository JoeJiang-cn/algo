package com.joe.algo.sort;

/**
 * @author Joe
 * 各种排序算法
 * 2021/7/18 15:59
 */
public class AwesomeSorter {
    /**
     * 冒泡排序
     * @param array
     */
    public void bubbleSort(int[] array) {
        int size = array.length;
        if (size <= 1) {
            // 只有一个元素，无需排序
            return;
        }
        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // 交换array[j]和array[j+1]
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                // 没有数据交换，结束循环
                break;
            }
        }
    }

    /**
     * 插入排序
     * @param array
     */
    public void insertionSort(int[] array) {
        int size = array.length;
        if (size <= 1) {
            // 只有一个元素，无需排序
            return;
        }
        for (int i = 1; i < size; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
    }

    /**
     * 选择排序
     * @param array
     */
    public void selectionSort(int[] array) {
        int size = array.length;
        if (size <= 1) {
            // 只有一个元素，无需排序
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            int min = array[i];
            int minIndex = 0;
            for (int j = i + 1; j < size; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            if (min != array[i]) {
                // 如果最小值不是当前元素的话，交换
                int tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
        }
    }

    /**
     * 归并排序
     * @param array
     */
    public void mergeSort(int[] array) {
        int size = array.length;
        if (size <= 1) {
            // 只有一个元素，无需排序
            return;
        }
        _mergeSort(array, 0, size - 1);
    }

    /**
     * 实际是一个后序遍历
     * @param array
     * @param start
     * @param end
     */
    private void _mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (start - end) / 2;
        _mergeSort(array, start, mid);
        _mergeSort(array, mid + 1, end);
        _merge(array, start, mid, end);
    }

    private void _merge(int[] array, int start, int mid, int end) {
        int i = start, j = mid + 1, k = 0;
        // 如果start = 0, end = 1, tmp数组的大小应该 = 2
        int[] tmp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (array[i] < array[j]) {
                // 比较合并
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }

        // 判断哪个子数组中有剩余数据
        int p = i, q = mid;
        if (j <= end) {
            // 说明后一个子数组还有
            p = j;
            q = end;
        }

        // 将剩余数据拷贝到临时数组
        while (p <= q) {
            tmp[k++] = array[p++];
        }

        // 将数据从临时数组拷贝回来
        if (k >= 0) System.arraycopy(tmp, 0, array, start, k);
    }

    /**
     * 快速排序
     * @param array
     */
    public void quickSort(int[] array) {
        int size = array.length;
        if (size <= 1) {
            // 只有一个元素，无需排序
            return;
        }
        _quickSort(array, 0, size - 1);
    }

    /**
     * 前序遍历
     * @param array
     * @param start
     * @param end
     */
    private void _quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = _partition(array, start, end);
        _quickSort(array, start, mid - 1); // 这边-1是因为mid的位置是确定的
        _quickSort(array, mid + 1, end);
    }

    private int _partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                // 和array[i]交换
                // 异或交换法不适用于相等元素，变成0了
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }
        // 处理pivot
        int tmp = array[i];
        array[i] = array[end];
        array[end] = tmp;
        return i;
    }

    /**
     * 计数排序
     * @param array 数据在0~n-1范围内
     * @param n
     */
    public void countSort(int[] array, int n) {
        int size = array.length;
        if (size <= 1) {
            // 只有一个元素，无需排序
            return;
        }
        int[] tmp = new int[size];
        int[] counter = new int[n];
        for (int i : array) {
            counter[i]++;
        }
        for (int j = 0; j < n - 1; j++) {
            counter[j + 1] += counter[j];
        }
        // array = {2, 5, 3, 0, 2, 3, 0, 3}
        // counter = {2, 2, 4, 7, 7, 8}
        // 2个0, 0个1, 2个2...
        for (int k = size - 1; k >= 0; k--) {
            int value = array[k];
            // 注意下标 - 1
            int position = counter[array[k]] - 1;
            tmp[position] = value;
            counter[array[k]]--;
        }
        System.arraycopy(tmp, 0, array, 0, size);
    }
}
