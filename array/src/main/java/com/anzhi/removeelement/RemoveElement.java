package com.anzhi.removeelement;

/**
 * LeetCode: 27: https://leetcode-cn.com/problems/remove-element/
 * 给定一个 nums 数组 和一个值 val， 你需要 原地 移除所有数值等于 val 的元素， 并返回移除数组后的新长度；
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组
 * 元素的顺序可以改变，你不需要考虑数组中超出新长度后面的元素
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {5, 4, 6, 4, 4, 4};
        Solution solution = new Solution();
        //int size = solution.removeElement(nums, 3);
        int size = solution.removeElement2(nums, 4);
        System.out.println(size);

    }
}
