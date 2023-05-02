package com.anzhi;

import com.anzhi.util.SortArrUtil;

/**
 * 编写一个选择排序demo
 */
public class SelectSortedDemo {

    public static void main(String[] args) {
        // 创建一个数组
        int[] arr = new int[]{7, 0, 8, 9, 1, 4, 5, 1};
        // 打印排序之前的数组
        SortArrUtil.printArr(arr);
        // 对数组进行排序
        selectSortArr(arr);
        // 打印排序之后的数组
        SortArrUtil.printArr(arr);
    }

    // 对数组进行排序
    public static void selectSortArr(int[] arr) {
        // 考虑边界调节，不用排序直接返回
        if (arr == null || arr.length < 2) {
            return ;
        }
        
        // 按照之前的想法，开始找最小值
        // 0 ～ N-1;
        // 1 ～ N-1;
        // 2 ～ N-1;
        int N = arr.length;
        for (int i=0; i<N-1; i++) {
            // 0 ~ N-1
            // 1 ~ N-1
            // i ~ N-1
            // 从下标为 i 的开始循环，因此，最小值的下标是 
            int minNumIndex = i;
            // 遍历开始找最小值, 因为一旦左边确认一个最小值后，就不会再动它，因此
            for (int j=i+1; j<N; j++) {
                // 遍历所有值，找到最小值
                minNumIndex = arr[j] < arr[minNumIndex] ? j : minNumIndex;
            }
            // 找到最最小值之后要进行数据交换
            SortArrUtil.swapData(arr, i, minNumIndex);
        }
    }


}
