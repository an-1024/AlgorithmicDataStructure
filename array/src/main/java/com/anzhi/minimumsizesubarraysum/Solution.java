package com.anzhi.minimumsizesubarraysum;

public class Solution {
    // 暴力解法
    public int minSubArrayLen(int target, int[] nums) {

        // 最终结果变量
        int result = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            // 每次开始重新求解最小子数组之和 >= target，sum值都要重新初始化
            int sum = 0;
            for(int j=i; j<nums.length; j++){
                // 计算子串求和
                sum += nums[j];
                if(sum >= target){ // 当求得的 sum 值大于target,此次循环结束
                    // 求和字符串长度
                    int subLength = j-i+1; // 计算最小子串长度
                    result = Math.min(result, subLength); // 每次与上一个值比较，取最小值
                    break;
                }
            }
        }
        return result  == Integer.MAX_VALUE ? 0 : result;
    }

    // 滑动窗口
    public int  minSubArrayLen2(int target, int[] nums){
        // 最终结果变量
        int result = Integer.MAX_VALUE;
        // 确定滑动窗口的起始位置
        int startIndex = 0;
        // 窗口内元素之和
        int sum = 0;
        // 窗口循环开始，确定窗口的结束条件
        for(int index=0; index<nums.length; index++){
            //计算窗口内所有元素之和
            sum += nums[index];
            // 确定窗口内的元素
            while(sum >= target){
                // 计算子数组长度
                int subLength = index - startIndex + 1;
                // 结果变量赋值
                result = result > subLength ? subLength : result;
                // 开始缩小窗口，即移动窗口起始位置
                sum -= nums[startIndex++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
