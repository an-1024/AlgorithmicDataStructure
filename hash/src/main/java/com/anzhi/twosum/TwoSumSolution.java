package com.anzhi.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和：利用 Hash 结构进行解题
 */
public class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            // 如果 HashMap 集合包含目标值减去数组中的值
            if(numsMap.containsKey(target - nums[i])){
                // 返回数组下标值
                return new int[]{numsMap.get(target-nums[i]), i};
            }
            // 如果不包含，将数组放入 Map 集合, 并记录本次数据对应下标
            numsMap.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        TwoSumSolution twoSumSolution = new TwoSumSolution();
        int[] sum = twoSumSolution.twoSum(nums, 9);
        System.out.println(sum);
    }
}
