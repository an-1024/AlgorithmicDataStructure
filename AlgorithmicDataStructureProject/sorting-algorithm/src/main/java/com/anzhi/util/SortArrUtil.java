package com.anzhi.util;

public class SortArrUtil {
    public static void printArr(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swapData(int[] arr, int currIndex, int swapIndex) {
        int tmp = arr[swapIndex];
        arr[swapIndex] = arr[currIndex];
        arr[currIndex] = tmp;
    }
}
