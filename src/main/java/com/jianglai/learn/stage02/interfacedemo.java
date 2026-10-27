package com.jianglai.learn.stage02;

public class interfacedemo {
    public static void main(String[] args) {
        Computable a = new A();
        Computable b = new B();
        System.out.println(a.M);
        System.out.println("" + a.f(20) + "," + b.g(12, 2));
        System.out.println(b.M);
        System.out.println("" + b.f(20) + "," + b.g(12, 2));
    }
}
