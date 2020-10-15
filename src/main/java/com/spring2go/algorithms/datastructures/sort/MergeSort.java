package com.spring2go.algorithms.datastructures.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int [] arr = {5,3,9,7,4,1,6,3,1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = start + (end - start) / 2;
        mergeSort(arr,start,middle);
        mergeSort(arr,middle + 1,end);  // + 1
//        merge(arr,start,middle,end);
        mergeBySentinel(arr,start,middle,end);
    }


    private static void merge(int[] arr, int start, int middle, int end) {
        int p = start;
        int q = middle+1;
        int[] tmp = new int[end - start + 1];  // 需要+1
        int k = 0;
        while (p <= middle && q <= end) {
            if (arr[p] <= arr[q]) {  // 稳定
                tmp[k++] = arr[p++];
            } else {
                tmp[k++] = arr[q++];
            }
        }

        int s = p;
        int e = middle;
        if (q <= end) {
            s = q;
            e = end;
        }
        while (s <= e) {
            tmp[k++] = arr[s++];
        }

        for (int i = 0; i < tmp.length; i++) {  // tmp.length
            arr[start+i] = tmp[i];      // index from start
        }
    }

    private static void mergeBySentinel(int[] arr, int start, int middle, int end) {

        int n1 = middle - start + 1;
        int n2 = end - middle;

        int[] arr1 = new int[n1 + 1];
        int[] arr2 = new int[n2 + 1];

        /*for (int i = 0; i < n1; i++) {
            arr1[i] = arr[start+i];
        }*/
        System.arraycopy(arr,start,arr1,0,n1);

        arr1[n1] = Integer.MAX_VALUE;

        /*for (int i = 0; i < n2; i++) {
            arr2[i] = arr[middle+1+i];
        }*/
        System.arraycopy(arr,middle+1,arr2,0,n2);

        arr2[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for (int k = start; k < end + 1; k++) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i++];
            } else {
                arr[k] = arr2[j++];
            }
        }

    }
}
