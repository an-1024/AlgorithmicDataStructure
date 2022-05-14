package com.anzhi.spiralmatrixii;

import java.util.Arrays;

/**
 * LeetCode: 59: https://leetcode-cn.com/problems/spiral-matrix-ii
 * 给你一个正整数 n，生成一个包含 1 到 n^2 所有元素， 且元素按顺时针螺旋排列的 n x n 正方形举证 matrix
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = solution.generateMatrix(4);
        System.out.println(Arrays.deepToString(nums));
    }
}
