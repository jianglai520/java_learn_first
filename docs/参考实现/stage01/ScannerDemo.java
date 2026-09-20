package com.jianglai.learn.stage01;

import java.util.Scanner;   // Scanner 在 java.util 包里,必须手动导入(java.lang 包才自动导入)

/**
 * 阶段一 · 第 3 课:运算符之后的另一半 —— 让程序能"接收输入"
 *
 * 运行(要在终端里手动敲输入):
 *   mvn -q compile
 *   java -cp target/classes com.jianglai.learn.stage01.ScannerDemo
 *
 * 运行后照着提示输入即可。也可以一次性把输入喂进去(每个回答一行):
 *   "Tom`n20`nComputer`n42`n" | java -cp target/classes com.jianglai.learn.stage01.ScannerDemo
 */
public class ScannerDemo {

    public static void main(String[] args) {

        // 创建一个"扫描器",绑定到标准输入(也就是键盘)
        Scanner sc = new Scanner(System.in);

        // ==================== 一、读取字符串和整数 ====================
        System.out.print("请输入你的姓名: ");
        String name = sc.nextLine();      // nextLine():读一整行,包含空格

        System.out.print("请输入你的年龄: ");
        int age = sc.nextInt();           // nextInt():读一个整数

        int birthYear = 2025 - age;
        System.out.println("你好," + name + "!你大约出生于 " + birthYear + " 年。");

        // ==================== 二、经典陷阱:nextInt() 后面的 nextLine() ====================
        // 你输入年龄时敲的回车符,nextInt() 只取走了数字,回车还留在缓冲区里。
        // 紧接着的 nextLine() 会立刻读到这个"空行",直接返回空字符串。
        sc.nextLine();   // ← 手动把残留的换行符吃掉,不加这行下面的专业就会读成空

        System.out.print("请输入你的专业: ");
        String major = sc.nextLine();
        System.out.println("专业是:" + major);

        // ==================== 三、输入校验:别让用户一输错程序就崩 ====================
        System.out.print("请输入一个整数(你可以故意输入字母试试): ");
        if (sc.hasNextInt()) {                 // 先"看一眼"下一个输入是不是整数
            int n = sc.nextInt();
            System.out.println("你输入的是 " + n + ",它的平方是 " + (n * n));
        } else {
            String bad = sc.next();            // 不是整数就按字符串读走,避免卡住
            System.out.println("[" + bad + "] 不是整数。程序没有崩溃,这就是 hasNextInt() 的价值。");
        }

        sc.close();   // 用完关闭,释放资源

        // ==================== 四、next() 和 nextLine() 的区别 ====================
        // 用一个字符串当输入源,这样不依赖键盘,方便观察区别
        Scanner demo = new Scanner("张三 李四 王五 赵六");
        System.out.println("next()     逐个读单词: " + demo.next() + " / " + demo.next());
        System.out.println("剩下的整行  nextLine(): [" + demo.nextLine() + "]");   // " 王五 赵六"
        // next()     遇到空格或回车就停,一次只读一个"单词"
        // nextLine() 一直读到行尾,能读进空格
        demo.close();

        // ==================== 五、其他常用的读取方法 ====================
        Scanner numbers = new Scanner("3.14 2.5 100 true");
        System.out.println("nextDouble(): " + numbers.nextDouble());   // 3.14
        System.out.println("nextDouble(): " + numbers.nextDouble());   // 2.5
        System.out.println("nextLong()  : " + numbers.nextLong());     // 100
        System.out.println("nextBoolean():" + numbers.nextBoolean());  // true
        numbers.close();

        // 小结:Scanner 的套路就是"一个 nextXxx() 对应一种类型"
        //      nextInt()      -> int
        //      nextDouble()   -> double
        //      next()         -> String(一个词)
        //      nextLine()     -> String(一整行)
        //      hasNextXxx()   -> boolean,先判断再读,防止崩溃
    }
}
