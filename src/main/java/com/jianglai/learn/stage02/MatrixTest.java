package com.jianglai.learn.stage02;

/**
 * 测试类：验证 Matrix 类的功能
 */
public class MatrixTest {
    public static void main(String[] args) {
        // 1. 构造矩阵
        Matrix m1 = new Matrix(2, 3);
        Matrix m2 = new Matrix(2, 3);

        // 2. 初始化矩阵元素
        m1.initValue(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        });
        m2.initValue(new int[][]{
                {6, 5, 4},
                {3, 2, 1}
        });

        System.out.println("矩阵 m1:");
        System.out.println(m1);
        System.out.println("\n矩阵 m2:");
        System.out.println(m2);

        // 3. 测试加法
        Matrix sum = m1.add(m2);
        System.out.println("\n加法结果 m1 + m2:");
        System.out.println(sum);

        // 4. 测试减法
        Matrix diff = m1.sub(m2);
        System.out.println("\n减法结果 m1 - m2:");
        System.out.println(diff);

        // 5. 测试 equals
        Matrix m3 = new Matrix(2, 3);
        m3.initValue(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        });
        System.out.println("\nm1.equals(m3): " + m1.equals(m3));
        System.out.println("m1.equals(m2): " + m1.equals(m2));

        // 6. 测试异常情况
        Matrix m4 = new Matrix(3, 2);
        try {
            m1.add(m4);
        } catch (IllegalArgumentException e) {
            System.out.println("\n尺寸不一致测试: " + e.getMessage());
        }
    }
}
