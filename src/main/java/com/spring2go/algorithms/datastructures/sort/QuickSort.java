package com.spring2go.algorithms.datastructures.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int [] arr = {5,3,9,7,4,1,6,3,1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int p, int q) {
        if (p >= q) return;

        int m = partition(arr, p, q);
        quickSort(arr, p, m - 1);
        quickSort(arr, m + 1, q);
    }

    private static int partition(int[] arr, int p, int q) {
        int pivot = arr[q];
        int i = p;
        for (int j = p; j < q; j++) {
            if (arr[j] < pivot) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                i++;
            }
        }

        arr[q] = arr[i];
        arr[i] = pivot;

        return i;
    }
}
