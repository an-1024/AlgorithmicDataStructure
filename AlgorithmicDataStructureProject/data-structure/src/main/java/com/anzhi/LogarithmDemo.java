package com.anzhi;

/**
 * 编写一个对数器，用来验证之前的排序算法的正确性。
 * 对数器，简而言之，就是一个绝对正确的方法和能产生大量随机样例的随机器的组合。
 */
public class LogarithmDemo {
    public static void main(String[] args) {
        int maxLength = 50;
        int maxValue = 1000;
        int loopTimes = 10000;

        for (int i = 0; i < loopTimes; i++) {
            int[] arr = lenRandomAndValueRandom(maxLength, maxValue);
            int[] arr2 = copyArray(arr);
            
            // 备份元素
            int[] arrBack = copyArray(arr);
            int[] arr2Back = copyArray(arr2);
            // 使用排序
            selectSortArr(arr);
            insertionSort2(arr2);
            if (!isSorted(arr)) {
                System.out.println("选择排序错误");
                printArr(arrBack);
                break;
            }
            if (!isSorted(arr2)) {
                System.out.println("插入排序错误");
                printArr(arr2Back);
                break;
            }
        }
    }

    // 编写长度、值都随机的一个数组
    public static int[] lenRandomAndValueRandom(int maxLength, int maxValue) {
        int len = (int) (Math.random() * maxLength);
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }

    // 拷贝数组
    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    // 判断数组是否相等
    // 这个方法的前提是 arr1 和 arr2 相等
    public static boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxValue > arr[i]) {
                return false;
            }
            maxValue = Math.max(maxValue, arr[i]);
        }
        return true;
    }

    private static void insertionSort2(int[] arr) {
        // 以下情况，不用排序直接返回
        if (arr == null || arr.length < 2) {
            return;
        }
        // 按照逻辑分析，只有末尾边界在变
        // 0-0 有序
        // 0-1 
        // 0-2 因此
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            // 每次比较都是当前下标的数与它左边的数据比较，因此
            int currIndex = end;
            // 首先与左边的数比较，知道左边没有数
            // 另一种情况，当前数大于左边的数，也终止循环
            // 这里可以有另一种写法
            // pre 表示前一个数，pre + 1 就是右边一个数，在比较完成后，pre-- 刚好是比较完当前的下标，pre-1 则是
            // 当前下标的左边的数。
            for (int pre = currIndex - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                // 两数交换
                swapData(arr, pre + 1, pre);
            }
        }
    }

    // 对数组进行排序
    private static void selectSortArr(int[] arr) {
        // 考虑边界调节，不用排序直接返回
        if (arr == null || arr.length < 2) {
            return;
        }

        // 按照之前的想法，开始找最小值
        // 0 ～ N-1;
        // 1 ～ N-1;
        // 2 ～ N-1;
        int N = arr.length;
        for (int i = 0; i < N - 1; i++) {
            // 0 ~ N-1
            // 1 ~ N-1
            // i ~ N-1
            // 从下标为 i 的开始循环，因此，最小值的下标是 
            int minNumIndex = i;
            // 遍历开始找最小值, 因为一旦左边确认一个最小值后，就不会再动它，因此
            for (int j = i + 1; j < N; j++) {
                // 遍历所有值，找到最小值
                minNumIndex = arr[j] < arr[minNumIndex] ? minNumIndex : j;
            }
            // 找到最最小值之后要进行数据交换
            swapData(arr, i, minNumIndex);
        }
    }

    public static void swapData(int[] arr, int currIndex, int swapIndex) {
        int tmp = arr[swapIndex];
        arr[swapIndex] = arr[currIndex];
        arr[currIndex] = tmp;
    }

    public static void printArr(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
