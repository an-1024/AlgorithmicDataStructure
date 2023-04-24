package com.anzhi;

/**
 * 利用阶乘进行比较算法优劣，感受以下算法的优美
 */
public class AlgorithmDemo {
    // 方案一，将每一步都展开计算
    public static long function (int N) {
        int ans = 0;
        for (int i=0; i<N; i++){
            ans += function2(i);
        }
        return ans;
    }
    
    public static long function2 (int N) {
        int ans = 1;
        for (int i=0; i<N; i++) {
            ans *= i;
        }
        return ans;
    }
    
    // 方案二：每次记录上一个阶乘的值，然后与当前值相加
    public static long function3 (int N) {
        int ans = 0;
        int curr = 1; // 1 的阶乘
        for (int i=0; i<N; i++) {
            curr *= i;
            ans += curr;
        }
        return ans;
    }
}
