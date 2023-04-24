package com.anzhi;

import com.anzhi.util.SortArrUtil;

/**
 * 冒泡排序的 demo
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        // 创建一个数组
        int[] arr = new int[]{7, 0, 8, 9, 1, 4, 5, 1};
        // 打印排序之前的数组
        SortArrUtil.printArr(arr);
        // 对数组进行排序
        bubbleSort(arr);
        // 打印排序之后的数组
        SortArrUtil.printArr(arr);
    }

    private static void bubbleSort(int[] arr) {
        // 0 ~ N-1
        // 0 ~ N-2
        int N = arr.length;
        // 限定边界 N-1
        for (int end=N; N>=0; N--) {
            // 两两比较，确定 index 位置上的最大值
            // 从第一位开始
            for (int index=1; index<N; index++) {
                // 如果第 index 位的数和第 index - 1 的比较，arr[index - 1] > arr[index]
                // 交换位置
                if (arr[index-1] > arr[index]) {
                    SortArrUtil.swapData(arr, index,index-1);
                }
            }
        }
    }
}
