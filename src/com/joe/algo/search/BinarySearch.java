package com.joe.algo.search;

public class BinarySearch {

    /**
     * 最简单的一种
     * 在没有重复元素的有序数组中查找
     * @param array
     * @return index
     */
    public int searchInUniqArray(int[] array, int value) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] > value) {
                // search in left side
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归版本
     * @param array
     * @param value
     * @return
     */
    public int recursivelySearchInUniqArray(int[] array, int value) {
        int low = 0, high = array.length - 1;
        return _recursivelySearchInUniqArray(array, low, high, value);
    }

    private int _recursivelySearchInUniqArray(int[] array, int low, int high, int value) {
        if (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] > value) {
                return _recursivelySearchInUniqArray(array, low, mid - 1, value);
            } else {
                return _recursivelySearchInUniqArray(array, mid + 1, high, value);
            }
        }
        return -1;
    }

    public int searchMostLeft(int[] array, int value) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value){
                low = mid + 1;
            } else {
                // 相等，需判断是不是最左边的
                if (mid == 0 || array[mid - 1] < value) {
                    return mid;
                } else {
                    // 在左边区间找
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
