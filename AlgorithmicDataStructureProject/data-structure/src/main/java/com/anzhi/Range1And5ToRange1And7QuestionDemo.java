package com.anzhi;

/**
 * 规定使用 f() 函数实现 1- 5 的等概率随机，然后利用 f() 函数实现 1-7 的等概率随机。
 * ( 只能使用f() 函数实现，相当于一个封装好的 jar 包)。
 */
public class Range1And5ToRange1And7QuestionDemo {
    public static void main(String[] args) {
        //testP();
        testP2();
    }

    private static void testP2() {
        int[] count = new int[8];
        int loopCount = 1000000;
        for (int i=0; i<loopCount; i++) {
            int ans = g2();
            count[ans]++;
        }
        
        for (int i=0; i<count.length; i++) {
            System.out.println("第" + i + "数出现了 " + count[i] + "次");
        }
    }

    private static void testP() {
        int count = 0;
        int loopCount = 1000;

        for (int i=0; i<loopCount; i++) {
            int ans = f2();
            if (ans == 0) {
                count++;
            }
        }

        System.out.println((double) count/(double) loopCount);
    }

    // 首先第一步实现 1-5 的等概率随机
    // 封装一个底层函数
    public static int f1() {
        return (int)(Math.random() * 5) + 1;
    }
    
    // 接着利用该函数实现一个 0，1 的等概率随机
    public static int f2() {
        int ans;
        do {
            ans = f1();
        } while (ans==3);
        // 将 1 2 3 4 5 以 3 为分割，1 2 为 0， 4 5 为 6
        return ans < 3 ? 0 : 1;
    }
    
    // 根据上面 0，1 等概率函数，那么就可以构建出 [0,7] 等概率
    // 111 就是 7
    public static int f3() {
        return (f2()<<2) + (f2()<<1) + f2();
    }
    
    // 于是我们可以根据 f3 推导出 [0,6] 的等概率
    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
            // 遇到 7 就继续循环
        } while (ans == 7);
        return ans;
    }
    // 修改 f4 重做条件，就可以直接推导出 [1,7] 等概率随机
    public static int g2() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 0);
        return ans;
    }
    
    // 最终我们推导出了 g() 函数，完成了 [1,7] 的等概率随机
    public static int g() {
        return f4() + 1;
    }
}
