package com.jianglai.learn.stage01;

/**
 * 阶段一 · 第 5 课:循环 for / while / do-while
 *
 * 运行:
 *   mvn -q compile
 *   java -cp target/classes com.jianglai.learn.stage01.LoopDemo
 */
public class LoopDemo {

    public static void main(String[] args) {

        // ==================== 一、for:明确知道要循环多少次时用 ====================
        // for (初始化; 循环条件; 每次循环后执行) { 循环体 }
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();   // 只为了换行

        // 三个部分的执行顺序要搞清楚:
        // 1. int i = 1     只执行一次
        // 2. i <= 5        每轮开始前判断,为 false 就结束
        // 3. 循环体
        // 4. i++           每轮结束后执行,然后回到第 2 步

        // 倒着数
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 步长可以是 2、3 甚至负数
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // ==================== 二、while:只知道条件,不知道要循环多少次 ====================
        int n = 1;
        while (n <= 5) {
            System.out.print(n + " ");
            n++;              // 【千万别忘】不改变条件变量的循环就是死循环
        }
        System.out.println("← while 结束");

        // while 的典型用途:不知道要算几次,只知道"算到满足条件为止"
        int steps = 0;
        int value = 1;
        while (value < 1000) {    // 每次翻倍,翻到超过 1000 为止
            value *= 2;
            steps++;
        }
        System.out.println("1 连续翻倍 " + steps + " 次后超过 1000,此时 value = " + value);

        // ==================== 三、do-while:至少执行一次 ====================
        int m = 100;
        do {
            System.out.println("do-while 的循环体执行了,m = " + m);
            m++;
        } while (m <= 5);   // 条件一开始就是 false,但循环体已经执行过一次了

        // while 和 do-while 的唯一区别:先判断还是先执行
        // 日常 99% 用 for 和 while,do-while 知道有就行

        // ==================== 四、break 和 continue ====================
        for (int i = 1; i <= 10; i++) {
            if (i == 3) {
                continue;      // 跳过本次循环剩下的代码,直接进入下一轮(i = 4)
            }
            if (i == 7) {
                break;         // 直接结束整个循环,后面的 8、9、10 都不再执行
            }
            System.out.print(i + " ");
        }
        System.out.println("← 输出的是 1 2 4 5 6");

        // ==================== 五、死循环与"靠 break 退出" ====================
        // 写 while (true) 通常是故意为之,配合 break / return 使用
        int count = 0;
        while (true) {
            count++;
            if (count >= 3) {
                break;
            }
        }
        System.out.println("while(true) 循环了 " + count + " 次后靠 break 退出");

        // ==================== 六、嵌套循环:九九乘法表 ====================
        for (int i = 1; i <= 9; i++) {          // 外层控制"行"
            for (int j = 1; j <= i; j++) {      // 内层控制"列",注意是 j <= i 形成三角形
                System.out.print(j + "×" + i + "=" + (i * j) + "\t");
            }
            System.out.println();               // 每行结束换一次行
        }

        // ==================== 七、带标签的 break:一次跳出多层循环 ====================
        // 普通 break 只能跳出"最内层"那一层。给外层起个名字就能一次跳出去。
        outer:                                  // 这叫"标签",名字自己取
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i * j == 4) {
                    System.out.println("找到 i = " + i + ", j = " + j);
                    break outer;                // 跳出 outer 标记的那一层
                }
            }
        }
        // 这个语法知道有就行,实际项目里很少用——多数情况可以把逻辑抽成方法然后 return

        // ==================== 八、循环三要素自查表 ====================
        // 以后循环写错(死循环、少循环一次、多循环一次),回来查这三条:
        //   1. 初始值对不对?      for (int i = 1; ...)
        //   2. 边界用 < 还是 <=?   0 下标的东西用 <,从 1 数的用 <=
        //   3. 有没有让条件趋近结束? i++ 漏了就是死循环,IDEA 一般不会提示你!
    }
}
