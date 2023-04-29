package com.anzhi;

/**
 * 编写一个对数器，用来验证之前的排序算法的正确性。
 * 对数器，简而言之，就是一个绝对正确的方法和能产生大量随机样例的随机器的组合。
 */
public class LogarithmDemo {
    // 编写长度、值都随机的一个数组
    public static int[] lenRandomAndValueRandom(int maxLength, int maxValue) {
        int len = (int)Math.random() * maxLength;
        int[] arr = new int[len];
        
        for (int i=0; i<len; i++) {
            arr[i] = (int)Math.random() * maxValue;
        }
        return arr;
    }
    
    
}
