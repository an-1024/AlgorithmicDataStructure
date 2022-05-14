package com.anzhi.spiralmatrixii;

public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        // 确定循环周期
        int cycle = n/2;
        // 设置起始下标
        int startx = 0;
        int starty = 0;
        int i;
        int j;
        // 设置每个周期循环时控制每层遍历长度
        // 因为是一个正方形顺时针填充，即上下左右，所以每层遍历
        // 不需要遍历到最后一个值，因为上层最后一个值时右边第一个值的开始
        // 右边最后一个值是下层最后一个值，而下层最开始的值是左边第一个值的开始
        // 所以 offset 初始值设置为 1
        int offset = 1;
        // 正方形矩阵最小值为1
        int count = 1;

        // 开始周期循环画矩阵
        while(cycle-- > 0){
            i = startx;
            j = starty;
            // 上边从左到右
            for(; j<n+starty-offset; j++){
                nums[i][j] = count++;
            }
            // 左边从上到下
            for(; i<n+startx-offset; i++){
                nums[i][j] = count++;
            }
            // 下边从右到左
            for(; j>starty; j--){
                nums[i][j] = count++;
            }
            // 左边从下到上
            for(; i>startx; i--){
                nums[i][j] = count++;
            }

            // 每画完一层 startx starty 下标自增1
            startx++;
            starty++;

            // 偏移量 +2 即画一层，每层长度遍历就要 -2
            // 上下左右都有值，中间的长度可不就减 2 了
            offset += 2;
        }

        // 确定中间值，如果 n 为奇数
        if(n%2!= 0){
            // 设置中间下标索引，当 n 为奇数时，
            int mid = n/2;
            nums[mid][mid] = n * n;
        }

        return nums;
    }
}
