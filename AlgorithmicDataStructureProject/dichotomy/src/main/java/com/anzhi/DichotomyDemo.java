package com.anzhi;

import com.anzhi.util.SortArrUtil;

import java.util.Arrays;

/**
 * 二分查找实现
 * 1. 利用二分查找，找到大于等于 num 的最左位置
 * 2. 利用二分查找，找到小于等于 num 的最右位置
 */
public class DichotomyDemo {

    public static void main(String[] args) {
        int loopCount = 500;
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
            } else if (isEqual(arr,value) && dichotomy(arr, value)) {
                System.out.println("成功, 已经查找到这个数： " + value);
                SortArrUtil.printArr(arr);
            }
            System.out.println();
        }
        System.out.println(success ? "成功" : "失败");
        System.out.println("/*-------------------------------利用二分查找，找到大于等于 num 的最左位置----------------------------------------------*/");
        for (int i=0; i<loopCount; i++) {
            int[] arr = generateArr(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
            int leftIndexInarr = findLeftIndexIAarr(arr, value);
            int leftIndex = findLeftIndex(arr, value);
            if (leftIndexInarr != leftIndex) {
                System.out.println("查找目标值为：" + value + " 出错了, 查找到最左数为： " + leftIndexInarr + " 二分查找到最左数为：" + leftIndex);
                SortArrUtil.printArr(arr);
                success = false;
            } else if (leftIndex != -1){
                System.out.println("数组中没有大于等于 num 的数，该数为：" + value);
                SortArrUtil.printArr(arr);
                success = false;
            } else if (leftIndex == leftIndexInarr) {
                System.out.println("查找目标值为：" + value + " 成功, 查找到最左数为： " + leftIndexInarr + " 二分查找到最左数为：" + leftIndex);
                SortArrUtil.printArr(arr);
                success = true;
            }
            System.out.println();
        }
        System.out.println(success ? "成功" : "失败");
        System.out.println("/*-------------------------------利用二分查找，找到小于等于 num 的最右位置----------------------------------------------*/");
        for (int i=0; i<loopCount; i++) {
            int[] arr = generateArr(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
            
            int rightIndexInArr = findRightIndexInArr(arr, value);
            int rightIndex = findRightIndex(arr, value);
            if (rightIndexInArr != rightIndex) {
                System.out.println("查找目标值为：" + value + " 出错了, 查找到最右数为： " + rightIndexInArr + " 二分查找到最右数为：" + rightIndex);
                SortArrUtil.printArr(arr);
                success = false;
            } else if (rightIndex != -1){
                System.out.println("数组中没有小于等于 num 的数，该数为：" + value);
                SortArrUtil.printArr(arr);
                success = false;
            } else if (rightIndex == rightIndexInArr) {
                System.out.println("查找目标值为：" + value + " 成功, 查找到最右数为： " + rightIndexInArr + " 二分查找到最右数为：" + rightIndex);
                SortArrUtil.printArr(arr);
                success = true;
            }
            System.out.println();
        }
        System.out.println(success ? "成功" : "失败");
    }
    
    // 二分查找算法
    public static boolean dichotomy(int[] arr, int target) {
        if (arr == null || arr.length==0) {
            return false;
        }
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
    
    // 二分查找利用二分查找，找到大于等于 num 的最左位置算法
    public static int findLeftIndex (int[] arr, int num) {
        if (arr==null || arr.length == 0) {
            return -1;
        }
        // 表示没有要找的数
        int ans = -1;
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R)/2;
            if (arr[mid] >= num) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    public static int findRightIndex (int[] arr, int num) {
        if (arr==null || arr.length == 0) {
            return -1;
        }
        // 表示没有要找的数
        int ans = -1;
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R)/2;
            if (arr[mid] <= num) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }
    
    // 编写对数器测试二分查找
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
    
    /*-----------------------------------------------------------------------------*/
    // 利用对数器测试利用二分查找，找到大于等于 num 的最左位置
    public static int findLeftIndexIAarr (int[] arr, int num) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
    }
    // 利用对数器测试利用二分查找，找到小于等于 num 的最右位置
    public static int findRightIndexInArr (int[] arr, int num) {
        int index = -1;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] <= num) {
                index = i;
            }
        }
        return index;
    }
}