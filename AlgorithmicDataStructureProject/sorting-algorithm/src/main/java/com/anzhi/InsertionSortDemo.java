package com.anzhi;

import com.anzhi.util.SortArrUtil;

/**
 * 插入排序
 */
public class InsertionSortDemo {
    public static void main(String[] args) {
        // 创建一个数组
        int[] arr = new int[]{7, 0, 8, 9, 1, 4, 5, 1};
        // 打印排序之前的数组
        SortArrUtil.printArr(arr);
        // 对数组进行排序
        insertionSort2(arr);
        // 打印排序之后的数组
        SortArrUtil.printArr(arr);
    }

    private static void insertionSort(int[] arr) {
        // 以下情况，不用排序直接返回
        if (arr == null || arr.length < 2) {
            return ;
        }
        // 按照逻辑分析，只有末尾边界在变
        // 0-0 有序
        // 0-1 
        // 0-2 因此
        int N = arr.length;
        for (int end=1; end<N; end++) {
            // 每次比较都是当前下标的数与它左边的数据比较，因此
            int currIndex = end;
            // 首先与左边的数比较，知道左边没有数
            // 另一种情况，当前数大于左边的数，也终止循环
            while (currIndex - 1 >= 0 && arr[currIndex - 1] > arr[currIndex]) {
                // 两数交换
                SortArrUtil.swapData(arr, currIndex, currIndex-1);
                // 下标左移
                currIndex--;
            }
        }
    }


    private static void insertionSort2(int[] arr) {
        // 以下情况，不用排序直接返回
        if (arr == null || arr.length < 2) {
            return ;
        }
        // 按照逻辑分析，只有末尾边界在变
        // 0-0 有序
        // 0-1 
        // 0-2 因此
        int N = arr.length;
        for (int end=1; end<N; end++) {
            // 每次比较都是当前下标的数与它左边的数据比较，因此
            int currIndex = end;
            // 首先与左边的数比较，知道左边没有数
            // 另一种情况，当前数大于左边的数，也终止循环
            // 这里可以有另一种写法
            // pre 表示前一个数，pre + 1 就是右边一个数，在比较完成后，pre-- 刚好是比较完当前的下标，pre-1 则是
            // 当前下标的左边的数。
            for (int pre=currIndex-1; pre>=0 && arr[pre] > arr[pre + 1]; pre--) {
                // 两数交换
                SortArrUtil.swapData(arr, pre+1, pre);
            }
        }
    }
    
}
