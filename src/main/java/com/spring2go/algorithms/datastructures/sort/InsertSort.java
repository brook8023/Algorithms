package com.spring2go.algorithms.datastructures.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int [] arr = {5,3,9,7,4,1,6,3,1};
//        insertSort(arr);
        insertSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if(value < arr[j]) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j+1] = value;
        }

    }

    public static void insertSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            for (int j = 0; j < i; j++) {
                if(value < arr[j]) {
                    for (int x = i; x > j; x--) {
                        arr[x] = arr[x-1];
                    }
                    arr[j] = value;
                    break;
                }
            }
        }

    }
}
