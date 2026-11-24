package com.jianglai.learn.stage05;

class Hare extends Thread {
    int sleepTime = 0, targetLength = 100;

    Hare(int sleepTime, int targetLength) {
        this.sleepTime = sleepTime;
        this.targetLength = targetLength;
        setName("Hare");
    }

    public void run() {
        while (true) {
            System.out.print("*");
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (targetLength <= 0) {
                System.out.printf(getName() + "到达目的地!\n");
//                stop();
                break;
            }
            targetLength--;
        }
    }
}

class Tortoise extends Thread {
    int sleepTime = 0, targetLength = 100;

    Tortoise(int sleepTime, int targetLength) {
        this.sleepTime = sleepTime;
        this.targetLength = targetLength;
        setName("Tortoise");
    }

    public void run() {
        while (true) {
            System.out.print("T");
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (targetLength <= 0) {
                System.out.printf(getName() + "到达目的地!\n");
//                stop();
                break;
            }
            targetLength--;
        }
    }
}

public class HareTortoiseRace {
    public static void main(String[] args) {
        Hare hare = new Hare(500, 100);
        Tortoise tortoise = new Tortoise(100, 100);

        hare.start();
        tortoise.start();
    }
}