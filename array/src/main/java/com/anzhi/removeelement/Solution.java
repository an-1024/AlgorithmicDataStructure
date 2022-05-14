package com.anzhi.removeelement;

public class Solution {
    public int removeElement(int[] nums, int val) {
        //数组长度
        int size = nums.length;
        // 第一层 for 循环
        for(int index = 0; index < size; index++){
            // 判断是否有目标值
            if(nums[index] == val){
                // 第二层 for 循环, 将每个数组元素向前移动一位
                for(int index2 = index +1; index2 < size; index2++){
                    nums[index2 -1] = nums[index2];
                }
                index--;  // index 也需要向前移动一位， 保证每一个元素都被遍历比较
                size--;
            }
        }

        return size;
    }

    // 快慢指针
    public int removeElement2(int[] nums, int val) {
        //数组长度
        int slowIndex = 0;
        for(int fastIndex=0; fastIndex<nums.length; fastIndex++){
            if(val != nums[fastIndex]){
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }
}
