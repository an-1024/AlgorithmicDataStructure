package com.anzhi.containerwithmostwater;

/**
 * 盛水最多的容器：双指针法
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int masArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            // 最短垂线决定面积大小 Math.min(height[l], height[r]) * (r - l)
            masArea = Math.max(masArea, Math.min(height[l], height[r]) * (r - l));
            // 根据左右指针大小，决定移动那个指针
            if (height[l] <= height[r]) {
                // 当左指针值小于右指针值，移动左指针，右指针作为边界
                ++l;
            } else {
                // 当左指针值大于右指针值，移动右指针，左指针作为边界
                --r;
            }
        }
        return masArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int maxArea = containerWithMostWater.maxArea(height);
        System.out.println(maxArea);
    }
}
