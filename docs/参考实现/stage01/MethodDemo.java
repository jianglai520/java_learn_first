package com.jianglai.learn.stage01;

/**
 * 阶段一 · 第 7 课:方法(函数)
 *
 * 这是阶段一里最重要的一课。学会"把一段逻辑封装成方法"之后,
 * 你才算从"写脚本"进入"写程序"。
 *
 * 运行:
 *   mvn -q compile
 *   java -cp target/classes com.jianglai.learn.stage01.MethodDemo
 *
 * 【方法的组成】
 *   修饰符  返回值类型  方法名(参数列表) {
 *       方法体
 *       return 返回值;   // 返回值类型是 void 时,这一句不需要
 *   }
 */
public class MethodDemo {

    // ==================== main 也是一个方法,只是 JVM 专门认它 ====================
    public static void main(String[] args) {

        // ==================== 一、调用有返回值的方法 ====================
        int sum = add(3, 5);            // 3 和 5 是"实参",add 里的 a b 是"形参"
        System.out.println("add(3, 5) = " + sum);

        // 有返回值的方法也可以直接当表达式用,甚至可以嵌套调用
        System.out.println("add(1, add(2, 3)) = " + add(1, add(2, 3)));   // 先算里面那层

        // ==================== 二、调用无返回值(void)的方法 ====================
        printLine();
        sayHello("张三");                // 传进去什么,里面就用什么
        printLine();

        // ==================== 三、方法重载(overload):同名不同参 ====================
        // 判定重载只看"方法名 + 参数列表",和返回值类型无关!
        System.out.println("add(1, 2)       = " + add(1, 2));         // 匹配 int,int
        System.out.println("add(1.5, 2.5)   = " + add(1.5, 2.5));     // 匹配 double,double
        System.out.println("add(1, 2, 3)    = " + add(1, 2, 3));      // 匹配三个参数那个

        // 重载的价值:调用者不用记一堆不同的方法名,一个 add 全搞定。
        // 你早就用过重载了:System.out.println() 能打印 int / double / String / boolean,
        // 就是因为 PrintStream 里有一大堆同名但参数不同的 println 方法。

        // ==================== 四、【重点】Java 只有"值传递" ====================
        // 含义:调用方法时,传进去的是"值的副本",不是变量本身。

        int x = 10;
        changeInt(x);
        System.out.println("调用 changeInt 之后,x = " + x);    // 【还是 10】里面的修改影响不到外面

        int[] arr = {1, 2, 3};
        changeArrayElement(arr);
        System.out.println("调用 changeArrayElement 之后,arr[0] = " + arr[0]);   // 变成 100 了

        reassignArray(arr);
        System.out.println("调用 reassignArray 之后,arr[0] = " + arr[0]);        // 还是 100

        // 为什么会这样?画个图就明白了:
        //   基本类型(int):传的是数字 10 的副本,方法里改副本,原件不变
        //   引用类型(数组):传的是"地址"的副本。地址指向同一个数组,
        //                  所以改元素内容会互相影响;
        //                  但在方法里 a = new int[]{...} 只是让副本指向了新对象,
        //                  原变量 arr 还指着老数组,所以不受影响。
        // 一句话:Java 里改"内容"能传出去,改"指向"传不出去。

        // ==================== 五、递归:方法自己调用自己 ====================
        System.out.println("5! = " + factorial(5));          // 120
        System.out.println("fib(10) = " + fib(10));          // 55

        // 递归必须有两个东西,缺一个就是 StackOverflowError:
        //   1. 递归出口(什么时候停下来)
        //   2. 每次递归都在向出口靠近

        // ==================== 六、关于 static,先记住结论 ====================
        // main 方法里想直接调用某个方法,那个方法就得加 static。
        // 为什么?static 表示"属于类"而不是"属于对象",所以不需要 new 对象就能调用。
        // 不加 static 的方法必须先创建对象才能用,那是阶段二"面向对象"的内容。
        // 现在:阶段一的练习方法统一都加 static 就行。
    }

    // ==================== 下面才是方法的定义部分 ====================

    /**
     * 求两个整数的和。
     *
     * @param a 第一个加数
     * @param b 第二个加数
     * @return 两数之和
     */
    public static int add(int a, int b) {
        return a + b;      // return 做了两件事:结束方法的执行 + 把值交回调用处
    }

    // 重载 1:参数类型不同
    public static double add(double a, double b) {
        return a + b;
    }

    // 重载 2:参数个数不同
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    /** 打印一条分隔线。没有返回值,用 void。 */
    public static void printLine() {
        System.out.println("--------------------");
        // void 方法里可以写 return; 表示"提前结束",但不能 return 一个值
    }

    /**
     * 向指定的人问好。
     *
     * @param name 要问候的人的名字
     */
    public static void sayHello(String name) {
        System.out.println("你好," + name + "!");
        // 小技巧:一旦有重复的输出字符串,就该考虑抽成方法了
    }

    /** 尝试修改一个 int,证明值传递:改不到外面。 */
    public static void changeInt(int n) {
        n = 999;           // 这里改的只是副本
    }

    /** 修改数组的元素内容:能影响到外面,因为指向同一个数组对象。 */
    public static void changeArrayElement(int[] a) {
        a[0] = 100;
    }

    /** 让参数指向一个全新的数组:影响不到外面,因为改的是副本的"指向"。 */
    public static void reassignArray(int[] a) {
        a = new int[]{7, 7, 7};
    }

    /**
     * 计算 n 的阶乘:5! = 5 × 4 × 3 × 2 × 1 = 120
     *
     * @param n 要求阶乘的数
     * @return n!
     */
    public static long factorial(int n) {
        if (n <= 1) {
            return 1;                    // 【递归出口】没有它就会无限递归
        }
        return n * factorial(n - 1);     // 把大问题变成"n 乘上小一号的问题"
    }

    /**
     * 斐波那契数列第 n 项:1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     * 规律:每一项等于前两项之和。
     */
    public static int fib(int n) {
        if (n <= 2) {
            return 1;                    // 【递归出口】
        }
        return fib(n - 1) + fib(n - 2);
    }
}
