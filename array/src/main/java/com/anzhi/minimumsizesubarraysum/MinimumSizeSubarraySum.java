package com.anzhi.minimumsizesubarraysum;

/**
 * LeetCode: 209: https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 给定一个含有 n 个正整数的数组和一个正整数 target。找出该数组中满足其和 >= target 的长度最小的连续子数组 [nums[l], nums[l+1], ..., nums[r-l], nums[r]]，并返回其长度，如果不存在符合条件的子数组， 返回 0。
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int[] nums2 = {1,4,4};
        int[] nums3 = {1,1,1,1,1,1,1,1};
        Solution solution = new Solution();
        //int result = solution.minSubArrayLen(11, nums3);
        int result = solution.minSubArrayLen2(7, nums);
        System.out.println(result);
    }
}
