package com.jianglai.learn.stage01;

/**
 * 阶段一 · 第 1 课:变量与八种基本数据类型
 *
 * 运行方式(在项目根目录执行两条命令):
 *   mvn -q compile
 *   java -cp target/classes com.jianglai.learn.stage01.Variables
 *
 * 或者直接在 IDEA 里点 main 方法左边的绿色三角。
 */
public class Variables {

    public static void main(String[] args) {

        // ==================== 一、整数型:byte / short / int / long ====================
        // 这四个的区别只有一个:能装多大的数。日常写代码 99% 用 int,
        // 只有在"int 装不下"或者"明确要和文件/网络格式对齐"时才用另外三个。
        byte  aByte  = 100;              // 1 字节,-128 ~ 127
        short aShort = 30_000;           // 2 字节,-32768 ~ 32767
        int   aInt   = 2_000_000_000;    // 4 字节,约 ±21 亿,这是"默认的整数类型"
        long  aLong  = 9_000_000_000L;   // 8 字节,超出 int 范围时必须加 L 后缀

        // 下划线 _ 只是给人看的分隔符,编译时会被忽略,2_000_000_000 就是 2000000000

        System.out.println("byte  = " + aByte);
        System.out.println("short = " + aShort);
        System.out.println("int   = " + aInt);
        System.out.println("long  = " + aLong);

        // 每种类型的边界值都放在对应的"包装类"里,不用自己背
        System.out.println("int 最小值 = " + Integer.MIN_VALUE);   // -2147483648
        System.out.println("int 最大值 = " + Integer.MAX_VALUE);   //  2147483647
        System.out.println("long 最大值 = " + Long.MAX_VALUE);     //  9223372036854775807

        // 超出范围会怎样?下面这行取消注释会直接编译报错:integer number too large
        // int overflow = 3_000_000_000;

        // ==================== 二、小数型:float / double ====================
        float  aFloat  = 3.14F;                 // 必须加 F!不加的话 3.14 默认是 double,赋给 float 会编译报错
        double aDouble = 3.141592653589793;     // 默认的小数类型,精度更高,日常就用 double

        System.out.println("float  = " + aFloat);
        System.out.println("double = " + aDouble);

        // 浮点数的经典坑:二进制无法精确表示 0.1 和 0.2
        System.out.println("0.1 + 0.2 = " + (0.1 + 0.2));   // 0.30000000000000004,不是 0.3!
        // 结论:涉及钱的计算不要用 float/double,后面会学 BigDecimal

        // ==================== 三、字符型 char ====================
        char letter  = 'A';   // 单个字符用单引号,且只能装一个字符
        char chinese = '中';   // Java 的 char 是 UTF-16 编码,一个常见汉字刚好占一个 char
        char byCode  = 66;    // 也可以直接用编码赋值,66 就是字符 'B'

        System.out.println("letter  = " + letter);
        System.out.println("chinese = " + chinese);
        System.out.println("byCode  = " + byCode);

        // char 和 int 可以互相转换,因为 char 本质就是一个数字
        System.out.println("'A' 的编码是 " + (int) letter);   // 65
        System.out.println("编码 65 对应字符 " + (char) 65);    // A

        // 常用转义字符
        System.out.println("制表符[\t]换行符[\n]反斜杠[\\]双引号[\"]");

        // ==================== 四、布尔型 boolean ====================
        boolean isStudent   = true;
        boolean isGraduated = false;
        System.out.println("isStudent = " + isStudent + ", isGraduated = " + isGraduated);
        // boolean 只有 true / false 两个值,不能用 0 / 1 代替(这点和 C 语言不同)

        // ==================== 五、String 不是基本类型! ====================
        // 基本类型只有上面这 8 种:byte short int long float double char boolean,记住它。
        // String 是"引用类型"(可以理解成"类"),只是它是唯一一个
        // 能像基本类型那样直接用字面量赋值的类,所以初学者容易误以为它是基本类型。
        String name = "jianglai";
        System.out.println("name = " + name);

        // ==================== 六、常量:final ====================
        final double PI = 3.14159;   // final 表示"只能赋值一次",之后不能再改
        // PI = 3.14;                // 取消注释会报错:cannot assign a value to final variable 'PI'
        System.out.println("PI = " + PI);

        // 常量的命名习惯:全大写 + 下划线,和普通变量一眼区分开
        final int MAX_SCORE = 100;
        System.out.println("MAX_SCORE = " + MAX_SCORE);

        // ==================== 七、类型转换 ====================
        // 方向 1:小范围 -> 大范围,自动转换,不会丢数据
        int    smallNum = 100;
        long   bigLong  = smallNum;    // int 自动变 long
        double bigDouble = smallNum;   // int 自动变 double
        System.out.println("自动转换: long=" + bigLong + ", double=" + bigDouble);

        // 方向 2:大范围 -> 小范围,必须强制转换,可能丢数据
        double price = 9.99;
        int    yuan  = (int) price;    // 注意:直接砍掉小数部分,不是四舍五入!
        System.out.println("(int) 9.99 = " + yuan);   // 9,不是 10

        int  bigNum = 130;
        byte cut    = (byte) bigNum;   // 130 超出 byte 上限,溢出后变成 -126
        System.out.println("(byte) 130 = " + cut);    // -126

        // 变量名规范:小驼峰(第一个单词小写,后面单词首字母大写),见名知义
        int studentAge = 18;
        System.out.println("studentAge = " + studentAge);

        // ==================== 八、两个新手必踩的坑 ====================
        // 坑 1:整数除法会丢掉小数部分
        System.out.println("5 / 2     = " + (5 / 2));      // 2  不是 2.5
        System.out.println("5 / 2.0   = " + (5 / 2.0));    // 2.5,只要有一个是小数就行
        System.out.println("(double)5 / 2 = " + ((double) 5 / 2));   // 2.5,强制转换也可以

        // 坑 2:整数相加溢出(结果会绕回到负数)
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Integer.MAX_VALUE + 1 = " + (maxInt + 1));   // -2147483648

        // ==================== 九、var:局部变量类型推断(Java 10+) ====================
        // 只是省去写类型名,Java 依然是强类型语言,类型一旦确定就不能改
        var count = 10;        // 编译器推断为 int
        var text  = "hello";   // 编译器推断为 String
        System.out.println("var: " + count + ", " + text);
        // count = "abc";      // 取消注释会报错:int 不能装字符串
    }
}
