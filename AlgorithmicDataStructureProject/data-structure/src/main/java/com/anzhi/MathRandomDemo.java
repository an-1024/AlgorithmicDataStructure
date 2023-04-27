package com.anzhi;

/**
 * 验证 Math.random() 的等概率
 */
public class MathRandomDemo {
    public static void main(String[] args) {
        int count = 0;
        int loopCount = 1000;
        for (int i=0; i<loopCount; i++) {
            double random = Math.random();
            if (random < 0.3) {
                count++;
            }
        }
        System.out.println((double)count /( double) loopCount);
        
        int K = 9;
        // ans 在 [0,8] 必然是等概率的
        int[] record = new int[9];
        for (int i=0; i<loopCount; i++) {
            int ans = (int) (Math.random() * K);
            record[ans]++;
        }
        
        for (int i=0; i<K; i++) {
            System.out.println(i + " 出现了" + record[i] + " 次");
        }
    }
}
