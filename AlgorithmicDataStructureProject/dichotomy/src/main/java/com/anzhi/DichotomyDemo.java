package com.anzhi;

import com.anzhi.util.SortArrUtil;

import java.util.Arrays;

/**
 * 二分查找实现
 * 1. 利用二分查找，找到大于等于 num 的最左位置
 * 2. 利用二分查找，找到小于等于 num 的最右位置
 * 3. 局部变量最小
 */
public class DichotomyDemo {

    public static void main(String[] args) {
        int loopCount = 500;
        int maxSize = 1000;
        int maxValue = 1000;

        System.out.println("/*-------------------------------二分查找 start----------------------------------------------*/");
        testDichotomy(loopCount, maxSize, maxValue);
        System.out.println("/*-------------------------------二分查找 end----------------------------------------------*/");

        System.out.println("/*-------------------------------利用二分查找，找到大于等于 num 的最左位置 start----------------------------------------------*/");
        testFindLeftIndexInArr(loopCount, maxSize, maxValue);
        System.out.println("/*-------------------------------利用二分查找，找到大于等于 num 的最左位置 end----------------------------------------------*/");

        System.out.println("/*-------------------------------利用二分查找，找到小于等于 num 的最右位置 start----------------------------------------------*/");
        testFindRightIndexInArr(loopCount, maxSize, maxValue);
        System.out.println("/*-------------------------------利用二分查找，找到小于等于 num 的最右位置 end----------------------------------------------*/");

        System.out.println("/*-------------------------------二分查找，找到局部最小值 start----------------------------------------------*/");
        testLocalMinimum(loopCount, maxSize, maxValue);
        System.out.println("/*-------------------------------二分查找，找到局部最小值 end----------------------------------------------*/");

    }


    private static void testLocalMinimum(int loopCount, int maxSize, int maxValue) {
        for (int i = 0; i < loopCount; i++) {
            int[] arr = localMinimumGenerateArr(maxSize,maxValue);
            int localMinNum = findLocalMinNum(arr);
            if (!checkLocalMinNum(arr, localMinNum)) {
                System.out.println("二分查找，找到局部最小值的位置失败：" + localMinNum);
                SortArrUtil.printArr(arr);
                break;
            }
            SortArrUtil.printArr(arr);
            System.out.println("二分查找，找到局部最小值的位置成功：" + localMinNum);
        }
    }

    private static void testFindRightIndexInArr(int loopCount, int maxSize, int maxValue) {
        for (int i = 0; i < loopCount; i++) {
            int[] arr = generateArr(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);

            int rightIndexInArr = findRightIndexInArr(arr, value);
            int rightIndex = findRightIndex(arr, value);
            if (rightIndexInArr != rightIndex) {
                System.out.println("查找目标值为：" + value + " 出错了, 查找到最右数为： " + rightIndexInArr + " 二分查找到最右数为：" + rightIndex);
                SortArrUtil.printArr(arr);
            } else if (rightIndex != -1) {
                System.out.println("数组中没有小于等于 num 的数，该数为：" + value);
                SortArrUtil.printArr(arr);
            } else if (rightIndex == rightIndexInArr) {
                System.out.println("查找目标值为：" + value + " 成功, 查找到最右数为： " + rightIndexInArr + " 二分查找到最右数为：" + rightIndex);
                SortArrUtil.printArr(arr);
            }
            System.out.println();
        }
    }

    private static void testFindLeftIndexInArr(int loopCount, int maxSize, int maxValue) {
        for (int i = 0; i < loopCount; i++) {
            int[] arr = generateArr(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
            int leftIndexInarr = findLeftIndexIAarr(arr, value);
            int leftIndex = findLeftIndex(arr, value);
            if (leftIndexInarr != leftIndex) {
                System.out.println("查找目标值为：" + value + " 出错了, 查找到最左数为： " + leftIndexInarr + " 二分查找到最左数为：" + leftIndex);
                SortArrUtil.printArr(arr);
            } else if (leftIndex != -1) {
                System.out.println("数组中没有大于等于 num 的数，该数为：" + value);
                SortArrUtil.printArr(arr);
            } else {
                System.out.println("查找目标值为：" + value + " 成功, 查找到最左数为： " + leftIndexInarr + " 二分查找到最左数为：" + leftIndex);
                SortArrUtil.printArr(arr);
            }
        }

    }

    private static void testDichotomy(int loopCount, int maxSize, int maxValue) {
        boolean success = true;
        for (int i = 0; i < loopCount; i++) {
            int[] arr = generateArr(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
            if (isEqual(arr, value) != dichotomy(arr, value)) {
                System.out.println("出错了, 查找不到这个数： " + value);
                SortArrUtil.printArr(arr);
                success = false;
            } else if (isEqual(arr, value) && dichotomy(arr, value)) {
                System.out.println("成功, 已经查找到这个数： " + value);
                SortArrUtil.printArr(arr);
            }
            System.out.println();
        }
    }

    /*----------------------------------算法的实现-------------------------------------------*/
    // 二分查找算法
    public static boolean dichotomy(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                L = mid + 1;
            } else if (arr[mid] > target) {
                R = mid - 1;
            }
        }
        return false;
    }

    // 二分查找利用二分查找，找到大于等于 num 的最左位置算法
    public static int findLeftIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 表示没有要找的数
        int ans = -1;
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    // 二分查找利用二分查找，找到小于等于 num 的最右位置算法
    public static int findRightIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // 表示没有要找的数
        int ans = -1;
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] <= num) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }

    // 二分查找-局部最小值
    public static int findLocalMinNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            // 表示没有找到局部最小值
            return -1;
        }
        // 如果 arr 只有一个值
        int N = arr.length;
        if (N == 1) {
            return 0;
        }

        // 如果 arr 只有两个值
        if (arr[0] < arr[1]) {
            return 0;
        }

        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }

        // 如果数组元素长度大于 2
        int L = 0;
        int R = N - 1;

        // R -1 确保 mid 在 L 和 R 的区间中
        // 否则最后比较只剩两个数的时候，循环的比较逻辑是不适用的
        while (L < R - 1) {
            int mid = (L + R) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                if (arr[mid] > arr[mid - 1]) { // 0-mid 必然存在局部最小值
                    R = mid - 1;
                } else if (arr[mid] > arr[mid + 1]) { // mid-N-1 必然存在局部最小值
                    L = mid + 1;
                }
            }
        }
        return arr[L] < arr[R] ? L : R;
    }

    /*----------------------------------对数器的编写-------------------------------------------*/
    /*----------------------------------编写对数器测试二分查找-------------------------------------------*/
    public static int[] generateArr(int maxLength, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxLength + 1))];
        for (int i = 0; i < arr.length; i++) {
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

    /*----------------------------------利用对数器测试利用二分查找，找到大于等于 num 的最左位置-------------------------------------------*/
    public static int findLeftIndexIAarr(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
    }

    /*----------------------------------利用对数器测试利用二分查找，找到小于等于 num 的最右位置-------------------------------------------*/
    public static int findRightIndexInArr(int[] arr, int num) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                index = i;
            }
        }
        return index;
    }

    /*--------------------------------局部最小值对数器---------------------------------------------*/
    private static int[] localMinimumGenerateArr(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize)];
        if (arr.length > 0) {
            arr[0] = (int) (Math.random() * (maxValue + 1) - (int) (Math.random() * maxValue));
            for (int i = 1; i < arr.length; i++) {
                // 创建的数组属于：任意相邻的两个数不相等
                do {
                    arr[i] = (int) (Math.random() * (maxValue + 1) - (int) (Math.random() * maxValue));
                } while (arr[i - 1] == arr[i]);
            }
        }
        return arr;
    }

    // 校验二分查找找到的
    private static boolean checkLocalMinNum(int[] arr, int midIndex) {
        if (arr.length == 0) {
            return midIndex == -1;
        }
        // 设置左右值
        int leftIndex = midIndex - 1;
        int rightIndex = midIndex + 1;

        boolean leftBigger = leftIndex < 0 || arr[midIndex] < arr[leftIndex];
        boolean rightBigger = rightIndex >= arr.length || arr[midIndex] < arr[rightIndex];

        return leftBigger && rightBigger;
    }
}