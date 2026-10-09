package com.jianglai.learn.stage01;

// Java 中 char 类型可以直接强制转换为 int，得到该字符对应的 Unicode 编码值。
public class UnicodeDemo {
    public static void main(String[] args) {
        char ni = '你';
        char wo = '我';
        char ta = '他';

        System.out.println("你: " + (int) ni + " 我: " + (int) wo + " 他: " + (int) ta);
    }
}
