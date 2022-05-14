# 二分查找

二分查找的核心在于定位边界问题：

第一个边界问题：循环的结束条件；

第二个边界问题：每次循环 **左右** 变量的赋值即每次循环开始的索引值；

## 二分查找思想：

首先了解二分的思想：

1. 首先将 **有序(这里以升序为例)** 数组分为大致相等的两个部分，即 nums.size/2；左右两部分数组nums[left], nums[right]；

2. 确定循环条件：当左边数组索引 left < right 或者 left <= right 时，循环结束；(为什么会有两种条件呢?)
   开发的都知道 数组下标是从 0 开始，所以 right 即 折半的索引取值决定了索引的区间，从而就决定了循环条件也会出现两种即 while(left < right) 
   or while(left < right);
   
3. 当 right = nums.size - 1 表明 target 在[left, right] 区间里, 当 right = nums.size; 表明 target 在 [left, right) 区间里;

**注意**: 溢位的问题: 注意 miidle = (left + right)/2 可能会出现溢位，所以采取另一种方法: middle = left + ((right -left)/2);
   
4. 当 nums[middle] < target 表明 目标值在右区间, 反之在左区间;

根据分析，确定了边界问题后，开始编程吧。

 



