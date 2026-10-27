package com.jianglai.learn.stage02;

interface Computable {
    int M = 10; // 在接口中，所有的变量都默认必须是公开的静态常量
    int f(int x);
    public abstract int g(int x, int y);
}
