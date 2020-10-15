package com.spring2go.algorithms.datastructures.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int [] arr = {5,3,9,7,4,1,6,3,1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min == i) {
                continue;
            }
            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
    }
}
