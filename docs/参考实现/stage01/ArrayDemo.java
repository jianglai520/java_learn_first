package com.jianglai.learn.stage01;

import java.util.Arrays;   // 数组工具类,提供 toString / sort 等现成方法

/**
 * 阶段一 · 第 6 课:数组
 *
 * 运行:
 *   mvn -q compile
 *   java -cp target/classes com.jianglai.learn.stage01.ArrayDemo
 */
public class ArrayDemo {

    public static void main(String[] args) {

        // ==================== 一、声明与初始化 ====================
        // 写法 1:先声明,再指定长度(元素会被填上"默认值")
        int[] scores = new int[5];

        // 写法 2:声明的同时直接给出元素(最常用)
        int[] nums = {90, 85, 77, 60, 99};

        // 推荐的写法是 int[] nums,把 [] 放在类型后面,能一眼看出"这是 int 的数组"

        System.out.println("数组长度 = " + nums.length);                   // 5
        System.out.println("第一个元素 nums[0] = " + nums[0]);             // 90  【下标从 0 开始!】
        System.out.println("最后一个元素 = " + nums[nums.length - 1]);     // 99
        // 记住这个公式:最后一个元素的下标永远是 length - 1

        // 注意 length 是"属性",不是方法,后面不加括号!(String 的 length() 才加括号)

        // 修改元素
        nums[1] = 88;
        System.out.println("修改后 nums[1] = " + nums[1]);

        // 各种类型的默认值(不手动赋值时)
        double[]  doubleDefaults  = new double[1];
        boolean[] booleanDefaults = new boolean[1];
        System.out.println("int 数组默认值 = " + scores[0]);                 // 0
        System.out.println("double 数组默认值 = " + doubleDefaults[0]);      // 0.0
        System.out.println("boolean 数组默认值 = " + booleanDefaults[0]);    // false
        String[] words = new String[1];
        System.out.println("String 数组默认值 = " + words[0]);           // null
        // 规律:数字是 0,布尔是 false,其他引用类型是 null

        // 【必踩的坑】下标越界:这不是编译错误,是运行时异常
        // System.out.println(nums[10]);   // ArrayIndexOutOfBoundsException,程序当场崩溃

        // ==================== 二、遍历方式一:普通 for(需要下标时用) ====================
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums[" + i + "] = " + nums[i]);
        }
        // 注意是 i < length,不是 i <= length!写 <= 就会越界

        // ==================== 三、遍历方式二:增强 for / for-each(只关心元素时用) ====================
        int sum = 0;
        for (int value : nums) {     // 读作"对 nums 里的每一个 value"
            sum += value;
        }
        System.out.println("总分 = " + sum);
        System.out.println("平均分(整数除法) = " + (sum / nums.length));              // 82,小数被砍掉
        System.out.println("平均分(保留小数) = " + ((double) sum / nums.length));     // 82.8,注意强制转换的位置

        // 增强 for 更简洁,但有两个限制:
        //   1. 拿不到下标
        //   2. 不能修改数组元素(那个 value 只是元素的副本)

        // ==================== 四、Arrays 工具类:别自己造轮子 ====================
        // 直接 println 一个数组,打印出来的是"地址",看不懂的
        System.out.println("直接打印数组 = " + nums);              // [I@1b6d3586 这种
        System.out.println("用 Arrays.toString = " + Arrays.toString(nums));   // [90, 88, 77, 60, 99]

        // 排序:Arrays.sort 是原地排序,会直接改动原数组!
        int[] sorted = nums.clone();      // 所以先复制一份再排,免得把原数据搞乱
        Arrays.sort(sorted);
        System.out.println("升序排序后 = " + Arrays.toString(sorted));

        // 查找:必须先排序,返回下标;找不到返回负数
        int index = Arrays.binarySearch(sorted, 77);
        System.out.println("77 的下标是 " + index);

        // 填充
        int[] filled = new int[5];
        Arrays.fill(filled, 7);
        System.out.println("Arrays.fill(filled, 7) = " + Arrays.toString(filled));

        // ==================== 五、三个常见小算法(手写一遍才记得住) ====================
        int[] data = {90, 85, 77, 55, 99};   // 55 分那个用来演示"不及格"

        // 1. 求最大值
        int max = data[0];                  // 假设第一个最大,然后逐个挑战
        for (int v : data) {
            if (v > max) {
                max = v;
            }
        }
        System.out.println("最大值 = " + max);

        // 2. 求和 / 计数
        int passCount = 0;
        for (int v : data) {
            if (v >= 60) {
                passCount++;
            }
        }
        System.out.println("及格人数 = " + passCount + " / " + data.length);

        // 3. 反转数组(双指针,一前一后往中间靠)
        int[] toReverse = {1, 2, 3, 4, 5};
        for (int i = 0, j = toReverse.length - 1; i < j; i++, j--) {
            int temp = toReverse[i];        // 交换两个变量必须借助临时变量
            toReverse[i] = toReverse[j];
            toReverse[j] = temp;
        }
        System.out.println("反转后 = " + Arrays.toString(toReverse));   // [5, 4, 3, 2, 1]

        // ==================== 六、二维数组:数组的数组 ====================
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println("matrix[1][2] = " + matrix[1][2]);          // 6,第 2 行第 3 列
        System.out.println("行数 = " + matrix.length);                  // 2
        System.out.println("第一行的列数 = " + matrix[0].length);        // 3

        // 遍历二维数组要用两层循环
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // 增强 for 版本同样要两层,外层变量类型是"一维数组"
        for (int[] row : matrix) {
            for (int v : row) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        // 每行的长度可以不一样(叫"锯齿数组")
        int[][] jagged = new int[3][];
        jagged[0] = new int[]{1};
        jagged[1] = new int[]{1, 2};
        jagged[2] = new int[]{1, 2, 3};
        System.out.println("锯齿数组第 3 行长度 = " + jagged[2].length);

        // ==================== 七、最后一句要点 ====================
        // 数组一旦创建,长度就固定了,不能变长也不能变短。
        // 需要"能自动扩容的数组"时,用 ArrayList(阶段三:集合框架)。
        //
        // 顺带一提:main 方法的 String[] args 就是一个一维数组,
        // 所以你可以用 args.length 和 args[0] —— 现在回头看 HelloWorld,是不是有感觉了?
    }
}
