package com.anzhi;

import com.anzhi.util.SortArrUtil;

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
            SelectSortedDemo.selectSortArr(arr);
            InsertionSortDemo.insertionSort2(arr2);
            if (!isSorted(arr)) {
                System.out.println("选择排序错误");
                SortArrUtil.printArr(arrBack);
                break;
            }
            if (!isSorted(arr2)) {
                System.out.println("插入排序错误");
                SortArrUtil.printArr(arr2Back);
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

}
