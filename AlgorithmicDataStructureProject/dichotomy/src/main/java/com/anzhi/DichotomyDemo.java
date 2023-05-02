package com.anzhi;

import com.anzhi.util.SortArrUtil;

import java.util.Arrays;

/**
 * 二分查找实现
 */
public class DichotomyDemo {

    public static void main(String[] args) {
        int loopCount = 500000;
        int maxSize = 10;
        int maxValue = 100;
        
        boolean success = true;
        
        for (int i=0; i<loopCount; i++) {
            int[] arr = generateArr(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
            if (isEqual(arr, value) != dichotomy(arr, value)) {
                System.out.println("出错了, 查找不到这个数： " + value);
                SortArrUtil.printArr(arr);
                success = false;
                // break;
            }
        }
        System.out.println(success ? "成功" : "失败");
    }
    
    public static boolean dichotomy(int[] arr, int target) {
        int L = 0;
        int R = arr.length -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] == target) {
                return true;
            }else if (arr[mid] < target) {
                L = mid + 1;
            }else if (arr[mid] > target) {
                R = mid - 1;
            }
        }
        return false;
    }
    
    // 编写对数器测试
    public static int[] generateArr(int maxLength, int maxValue) {
        int[] arr = new int[(int)(Math.random() * (maxLength + 1))];
        for (int i=0; i<arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
    
    public static boolean isEqual(int[] arr, int num) {
        for (int cur : arr) {
            if (cur == num) {
                return true;
            }
        }
        return false;
    }
}