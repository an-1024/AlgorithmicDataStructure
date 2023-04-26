package com.anzhi;

public class PrefixSumDemo {

    private static int[] oneDimensionalPreSum;

    private static int[][] twoDimensionalPreSum;

    /**
     * 构建一维前缀和
     *
     * @param arr
     */
    public static void buildOneDimensionalPrefixRangSum(int[] arr) {
        int N = arr.length;
        oneDimensionalPreSum = new int[N];
        oneDimensionalPreSum[0] = arr[0];

        for (int i = 1; i < N; i++) {
            oneDimensionalPreSum[i] = oneDimensionalPreSum[i - 1] + arr[i];
        }
    }

    // 一维前缀用法
    public static int oneDimensionalPrefixRangeSum(int L, int R, int length) {
        if (L>length || R > length) {
            return 0;
        }
        return L == 0 ? oneDimensionalPreSum[L] : oneDimensionalPreSum[R] - oneDimensionalPreSum[L - 1];
    }

    public static void buildTwoDimensionalPrefixRangSum(int[] arr) {
        int N = arr.length;
        twoDimensionalPreSum = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) {
                    twoDimensionalPreSum[0][0] = arr[0];
                    continue;
                } else if (j < i) {
                    continue;
                }
                twoDimensionalPreSum[i][j] = twoDimensionalPreSum[i][j - 1] + arr[j];
            }
        }
    }
    
    // 二维前缀和用法
    public static int twoDimensionalPrefixRangSum(int L, int R, int length) {
        if (L>length || R > length) {
            return 0;
        }
        return twoDimensionalPreSum[L][R];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 6, 7};
        buildTwoDimensionalPrefixRangSum(arr);
        System.out.println(twoDimensionalPrefixRangSum(0,5, arr.length));
    }
}
