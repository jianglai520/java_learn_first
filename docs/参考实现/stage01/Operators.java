package com.jianglai.learn.stage01;

/**
 * 阶段一 · 第 2 课:运算符
 *
 * 运行:
 *   mvn -q compile
 *   java -cp target/classes com.jianglai.learn.stage01.Operators
 */
public class Operators {

    public static void main(String[] args) {

        // ==================== 一、算术运算符 + - * / % ====================
        int a = 7, b = 2;   // 同一类型可以一行声明多个变量

        System.out.println("a + b = " + (a + b));   // 9
        System.out.println("a - b = " + (a - b));   // 5
        System.out.println("a * b = " + (a * b));   // 14
        System.out.println("a / b = " + (a / b));   // 3  ← 整数除法,小数被砍掉
        System.out.println("a % b = " + (a % b));   // 1  ← % 是取余数(模)

        // % 最常用的场景:判断能不能被整除
        System.out.println("10 是偶数吗?" + (10 % 2 == 0));   // true

        // 负数取余的结果符号跟着"被除数"走
        System.out.println("-7 % 2 = " + (-7 % 2));   // -1

        // ==================== 二、字符串拼接:一个必须记住的坑 ====================
        // + 号遇到 String 就变成"拼接",而且是从左往右依次计算
        System.out.println("1 + 2 = " + 1 + 2);     // 1 + 2 = 12   ← 先拼成字符串,又拼了一个 2
        System.out.println("1 + 2 = " + (1 + 2));   // 1 + 2 = 3    ← 加括号才是先算加法

        // ==================== 三、自增自减 ++ -- ====================
        int i = 5;
        System.out.println("i++ 输出的是旧值:" + i++);   // 5(先取值,后加 1)
        System.out.println("此时 i = " + i);            // 6
        System.out.println("++i 输出的是新值:" + ++i);   // 7(先加 1,后取值)

        // 单独一行写 i++; 时两种写法没区别,只有"参与其他运算"时才有区别

        // ==================== 四、赋值与复合赋值 ====================
        int x = 10;
        x += 5;   // 等价于 x = x + 5
        System.out.println("x += 5 之后,x = " + x);   // 15
        x -= 3;   // x = x - 3
        x *= 2;   // x = x * 2
        x /= 4;   // x = x / 4
        System.out.println("连续复合赋值后,x = " + x);   // 6

        // 复合赋值有一个隐藏好处:它自带强制类型转换
        byte small = 10;
        small += 5;   // 编译通过
        System.out.println("byte small += 5 后 = " + small);
        // small = small + 5;   // 取消注释会编译报错:int 不能直接赋给 byte

        // ==================== 五、比较运算符 ====================
        // 结果一定是 boolean( true / false )
        System.out.println("3 > 2   -> " + (3 > 2));      // true
        System.out.println("3 == 3  -> " + (3 == 3));     // true
        System.out.println("3 != 3  -> " + (3 != 3));     // false
        System.out.println("3 >= 4  -> " + (3 >= 4));     // false

        // 坑:= 是赋值,== 才是比较。写错时 Java 会报编译错误,算是保护你
        // if (a = 1) { }   // 编译错误:int cannot be converted to boolean

        // ==================== 六、字符串比较:必须用 equals ====================
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println("s1 == s2        -> " + (s1 == s2));        // false,比的是内存地址
        System.out.println("s1.equals(s2)   -> " + s1.equals(s2));    // true,比的才是内容

        // 记死这一条:比较字符串内容一律用 equals,不要用 ==

        // ==================== 七、逻辑运算符 && || ! 与"短路" ====================
        int age = 20;
        boolean canVote = age >= 18 && age <= 60;   // 并且
        boolean isSpecial = age < 18 || age > 60;   // 或者
        System.out.println("能投票:" + canVote + ",是特殊情况:" + isSpecial + ",取反:" + !canVote);

        // 短路:&& 左边为 false 时,右边根本不执行;|| 左边为 true 时,右边也不执行
        int calls = 0;
        boolean r1 = false && (++calls > 0);
        System.out.println("false && (...) 之后 calls = " + calls);   // 0,右边没执行

        // 短路的实际价值:可以用它来防止空指针 / 除零
        int divisor = 0;
        boolean safe = divisor != 0 && (100 / divisor > 1);   // 不会抛异常,因为右边被短路跳过了
        System.out.println("除数保护结果 = " + safe);           // false

        // ==================== 八、三元运算符 条件 ? 值1 : 值2 ====================
        int score = 75;
        String level = score >= 60 ? "及格" : "不及格";
        System.out.println(score + " 分是:" + level);
        // 等价于 if-else,但适合"二选一然后赋值"这种简单场景,能少写好几行

        // 可以嵌套,但嵌套超过两层就别用了,可读性会急剧下降
        String grade = score >= 90 ? "A" : score >= 60 ? "B" : "C";
        System.out.println("等级 = " + grade);

        // ==================== 九、位运算:知道有这回事就行 ====================
        // 直接对二进制位操作。初学阶段用不到,但看源码时会遇到
        System.out.println("6 & 3  = " + (6 & 3));     // 2   按位与
        System.out.println("6 | 3  = " + (6 | 3));     // 7   按位或
        System.out.println("6 ^ 3  = " + (6 ^ 3));     // 5   按位异或
        System.out.println("6 << 1 = " + (6 << 1));    // 12  左移 1 位 = 乘 2
        System.out.println("6 >> 1 = " + (6 >> 1));    // 3   右移 1 位 = 除以 2
        System.out.println("~6     = " + (~6));        // -7  按位取反

        // ==================== 十、运算符优先级 ====================
        // 记不住优先级不要紧,加括号就行。括号永远是最清晰的做法
        int mixed = 2 + 3 * 4;        // 14,先乘除后加减
        int clear = (2 + 3) * 4;      // 20,括号优先
        System.out.println("2 + 3 * 4 = " + mixed + ",(2 + 3) * 4 = " + clear);
    }
}
