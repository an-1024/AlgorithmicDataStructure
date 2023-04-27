package com.anzhi;

/**
 * Math.random 的取值为[0,1)
 * x 属于 [0,1)，如何将 x 在 [0,1) 出现的概率由 x 调整为 x^2, x^3 
 */
public class MathPowerRandom {

    public static void main(String[] args) {
        int count = 0;
        int loopCount = 10000;
        
        double x = 0.17;
        for (int i=0; i<loopCount; i++) {
            if (xToXPowerMin() < x) {
                count++;
            }
        }

        System.out.println((double) count / (double) loopCount);
        System.out.println((double) 1- Math.pow((double) 1-x, 2));
    }
    
    // Math.random 值属于 [0,1)，
    // x 属于 [0,1)，将 x 在 [0,1) 出现的概率由原来的 x 调整为 x^2
    public static double xToXPower() {
        // 每个 Math.random() 都是独立的，调用了两次 Math.random()，只有两次都命中
        // 这个范围，那么最终返回的范围才是 [0,x]。第一个概率是 x，第二个也是 x，x^2
        return Math.max(Math.random(), Math.random());
    }

    public static double xToXPowerMin() {
        return Math.min(Math.random(), Math.random());
    }
    
    // 那么 x^3 就是
    public static double xToXThreePower() {
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }
}
