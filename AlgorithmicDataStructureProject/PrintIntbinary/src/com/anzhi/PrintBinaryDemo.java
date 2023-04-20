package com.anzhi;

/**
 * 打印一个整数的二进制
 */
public class PrintBinaryDemo {
    public void printIntBinary(int num) {
        for (int i=31; i>=0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : 1);
        }
        System.out.println();
    }
}
