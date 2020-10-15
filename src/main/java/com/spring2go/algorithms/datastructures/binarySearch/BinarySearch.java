package com.spring2go.algorithms.datastructures.binarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 4, 6, 7, 8, 9};
        System.out.println(binarySearch(arr, 4));
        System.out.println(binarySearchFirst(arr, 4));
        System.out.println(binarySearchFirstLe(arr, 3));
        System.out.println(binarySearchFirstLe(arr, 4));
        System.out.println(binarySearchFirstLe(arr, 5));
    }

    public static int binarySearch(int[] arr, int value) {
        if (arr == null) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = left + ((right - left) >> 1);  // + has priority over >>, need ()
            if (value == arr[middle]) {
                return middle;
            } else if (value < arr[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

    /**
     * 找到第一个等于value的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearchFirst(int[] arr, int value) {
        if (arr == null) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = left + ((right - left) >> 1);  // + has priority over >>, need ()
            if (value == arr[middle]) {
                if (middle == 0 || arr[middle - 1] != value) {
                    return middle;
                } else {
                    right = middle - 1;
                }
            } else if (value < arr[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

    /**
     * 找到第一个大于等于value的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearchFirstLe(int[] arr, int value) {
        if (arr == null) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = left + ((right - left) >> 1);  // + has priority over >>, need ()
            if (value <= arr[middle]) {
                if (middle == 0 || arr[middle - 1] < value) {
                    return middle;
                } else {
                    right = middle - 1;
                }
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}
