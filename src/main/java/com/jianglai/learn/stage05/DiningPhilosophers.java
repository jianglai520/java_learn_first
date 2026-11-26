package com.jianglai.learn.stage05;
import java.util.Random;

class Chopstick {
    synchronized void use() throws InterruptedException {
        Thread.sleep(100);
    }
}

class Philosopher extends Thread {
    private final int id;
    private final Chopstick left, right;
    private final boolean leftFirst;
    private static final Random r = new Random();
    private static final int MEALS = 5;          // ★ 新增：每人吃 5 顿

    Philosopher(int id, Chopstick l, Chopstick rt, boolean leftFirst) {
        this.id = id; this.left = l; this.right = rt; this.leftFirst = leftFirst;
        setName("P" + id);                        // ★ 新增：线程命名，日志更清楚
    }

    @Override
    public void run() {
        try {
            for (int meal = 1; meal <= MEALS; meal++) {   // ★ while(true) → for
                System.out.println(getName() + " 思考");
                Thread.sleep(r.nextInt(200));

                Chopstick first  = leftFirst ? left : right;
                Chopstick second = leftFirst ? right : left;

                synchronized (first) {
                    synchronized (second) {
                        System.out.println(getName() + " 第" + meal + "次进餐");
                        Thread.sleep(r.nextInt(200));
                    }
                }
            }
            System.out.println(getName() + " 吃饱离席");   // ★ 新增：退出提示
        } catch (InterruptedException e) { }
    }
}

public class DiningPhilosophers {
    public static void main(String[] args) throws InterruptedException {
        int N = 5;
        Chopstick[] cs = new Chopstick[N];
        for (int i = 0; i < N; i++) cs[i] = new Chopstick();

        Philosopher[] ps = new Philosopher[N];              // ★ 保存线程引用
        for (int i = 0; i < N; i++) {
            ps[i] = new Philosopher(i, cs[i], cs[(i + 1) % N], i % 2 == 1);
            ps[i].start();
        }

        for (Philosopher p : ps) p.join();                  // ★ 等所有线程结束
        System.out.println("===== 全部哲学家进餐完毕，程序正常结束 =====");
    }
}