package com.anzhi.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三数之和：
 * 双指针法：难点在于不重复解。
 * 1. 模式识别：利用排序避免重复答案
 * 2. 降低复杂度，变成 twoSum
 * 3. 利用双指针找到所有解
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) {
            return ans;
        }
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break; // 排序之后，如果当前数字大于0，那么数组中一定没有相加等于 0 的三个数，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 去重
            }
            // 左指针
            int L = i + 1;
            // 右指针
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]){
                        L++; // 去重
                    }
                    while (L < R && nums[R] == nums[R - 1]){
                        R--; // 去重
                    }
                    L++;
                    R--;
                } else if (sum < 0){
                    // 三数之和小于 0，移动左指针
                    L++;
                }
                else if (sum > 0){
                    // 三数之和大于 0， 移动右指针，
                    R--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,-1, 1, 0};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}
