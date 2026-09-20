package com.jianglai.learn.stage01;

/**
 * 阶段一 · 第 4 课:分支结构 if / switch
 *
 * 运行:
 *   mvn -q compile
 *   java -cp target/classes com.jianglai.learn.stage01.BranchDemo
 */
public class BranchDemo {

    public static void main(String[] args) {

        // ==================== 一、if / else if / else ====================
        int score = 86;

        if (score >= 90) {
            System.out.println("优秀");
        } else if (score >= 80) {
            System.out.println("良好");
        } else if (score >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }

        // 【重要】判断是从上往下逐个进行的,一旦命中就不再往下看了。
        // 所以范围的判断必须"从大到小"或"从小到大"排好序。
        // 如果把 score >= 60 写在最前面,那 95 分也会被判定成"及格"。

        // ==================== 二、Java 的条件必须是 boolean ====================
        // 这点和 C / JavaScript 不同:Java 不允许用 0、非 0 或对象当条件
        // if (1) { }              // 编译错误:int cannot be converted to boolean
        // if (score = 100) { }    // 编译错误(这里是赋值不是比较),Java 帮你避免了 C 语言里的经典 bug

        // ==================== 三、if 的嵌套 ====================
        boolean isMember = true;
        double price = 200.0;

        if (price >= 100) {
            if (isMember) {
                System.out.println("满 100 且是会员,打 8 折 → " + (price * 0.8));
            } else {
                System.out.println("满 100 非会员,打 9 折 → " + (price * 0.9));
            }
        } else {
            System.out.println("不满 100,不打折 → " + price);
        }

        // 嵌套太深时可读性会变差,通常可以把条件用 && 合并,或者提前 return(学到方法时再说)

        // ==================== 四、传统 switch:别忘了 break ====================
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("星期一");
                break;          // 不加 break 会继续往下执行,叫"穿透"(fall through)
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            default:            // 所有 case 都不匹配时执行;位置可以放最后(推荐)
                System.out.println("未知的星期");
                break;
        }

        // 穿透有时候是"特性":多个 case 共用同一段逻辑时可以故意不写 break
        int month = 5;
        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println(month + " 月属于春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println(month + " 月属于夏季");
                break;
            default:
                System.out.println("这个示例只看春、夏两季");
                break;
        }

        // ==================== 五、switch 箭头写法(Java 14+,推荐) ====================
        String grade = "B";
        switch (grade) {
            case "A" -> System.out.println("90 分以上");
            case "B" -> System.out.println("80 ~ 89 分");
            case "C", "D" -> System.out.println("60 ~ 79 分");   // 一个 case 可以写多个值
            default -> System.out.println("不及格或其他");
        }
        // 箭头写法的好处:不用写 break,永远不会穿透,代码短了一大截
        // switch 能判断的类型:byte / short / char / int / String / 枚举,
        // 不能判断 long / float / double / boolean

        // ==================== 六、switch 表达式:直接把结果"赋值"给变量 ====================
        int month2 = 11;
        String season = switch (month2) {          // 注意:这是一个表达式,末尾要有分号
            case 3, 4, 5   -> "春季";
            case 6, 7, 8   -> "夏季";
            case 9, 10, 11 -> "秋季";
            case 12, 1, 2  -> "冬季";
            default        -> "无效月份";           // 必须穷尽所有可能,否则编译报错
        };
        System.out.println(month2 + " 月是" + season);

        // 分支里要写多行代码时,用大括号 + yield 交出结果
        int score2 = 55;
        String result = switch (score2 / 10) {
            case 10, 9 -> "A";
            case 8     -> "B";
            case 7     -> "C";
            case 6     -> "D";
            default -> {
                System.out.println("  (进入 default 分支,先做点别的事)");
                yield "F";     // yield 类似 return,但用于 switch 表达式
            }
        };
        System.out.println(score2 + " 分对应等级 " + result);

        // ==================== 七、if 还是 switch?怎么选 ====================
        // if     :判断范围、组合条件(&& ||)、复杂逻辑   → 更灵活
        // switch :判断"等于某几个固定值"               → 更清晰
        // 拿不准就用 if,不会错。
    }
}
