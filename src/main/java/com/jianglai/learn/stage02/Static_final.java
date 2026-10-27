package com.jianglai.learn.stage02;

public class Static_final {
    static int i = 10;  // 静态代码块 其中i为静态变量
    static final int k = 20;  // k为静态常量
    static {
        i = i + 5;
    }
    public static void main(String[] args) {
        System.out.println("i = " + i);
        System.out.println("k = " + k);
//        k = 30;
    }
    static { i = i/2;}
}
