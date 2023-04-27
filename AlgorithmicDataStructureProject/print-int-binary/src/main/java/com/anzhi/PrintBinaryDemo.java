package com.anzhi;

/**
 * 打印一个整数的二进制
 */
public class PrintBinaryDemo {
    public static void printIntBinary(int num) {
        for (int i=31; i>=0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
            if(i%4 == 0) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int num = -2147483648;
        printIntBinary(num);
        System.out.println(~num);
        printIntBinary(~num);
    }
}
