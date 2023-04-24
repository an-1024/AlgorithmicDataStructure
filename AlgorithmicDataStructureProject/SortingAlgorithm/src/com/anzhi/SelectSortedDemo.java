package com.anzhi;

/**
 * 编写一个选择排序demo
 */
public class SelectSortedDemo {

    public static void main(String[] args) {
        // 创建一个数组
        int[] arr = new int[]{7, 0, 8, 9, 1, 4, 5, 1};
        // 打印排序之前的数组
        printArr(arr);
        // 对数组进行排序
        selectSortArr(arr);
        // 打印排序之后的数组
        printArr(arr);
    }

    // 对数组进行排序
    private static void selectSortArr(int[] arr) {
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
            swapData(arr, i, minNumIndex);
        }
    }

    private static void swapData(int[] arr, int j, int minNumIndex) {
        int tmp = arr[minNumIndex];
        arr[minNumIndex] = arr[j];
        arr[j] = tmp;
    }

    private static void printArr(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
