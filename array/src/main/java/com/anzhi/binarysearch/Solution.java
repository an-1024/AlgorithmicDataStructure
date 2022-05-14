package com.anzhi.binarysearch;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0; //左区间索引起始位置
        int right = nums.length - 1; //右区间索引终止
        while(left <= right){  // 此时 如果target存在，那么不然在区间[left, right]中
            int middle = left + ((right - left) >> 2);
            if(target == nums[middle]){
                return middle;
            }else if(target < nums[middle]){ //target 小于 nums[middle] 表明目标值在左区间中
                right = middle - 1;  // right 缩小区间
            }else{ // 表明 目标值在右区间中
                left = middle + 1;
            }
        }
        return -1;
    }
}
