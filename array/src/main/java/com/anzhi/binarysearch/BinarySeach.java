package com.anzhi.binarysearch;

/**
 * LeetCode: 704: https://leetcode-cn.com/problems/binary-search/
 * 给定一个 n 个元素有序(升序)整数组 nums 和一个目标值 target，实现函数搜索 nums 中的 target，如果目标值存在则返回下标，不存在返回 -1
 */
public class BinarySeach {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};

        Solution solution = new Solution();
        int search = solution.search(nums, 7);
        System.out.println(search);
    }
}
