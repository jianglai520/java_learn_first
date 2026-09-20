# java_learn_first

Java 学习项目(Maven),记录从基础语法到 Spring Boot 的练习代码。

## 📊 学习进度

| 阶段 | 内容 | 状态     |
|------|------|--------|
| 阶段一 | Java 基础语法 | 🏃 进行中 |
| 阶段二 | 面向对象核心 | ⏳ 待开始 |
| 阶段三 | 集合框架与泛型 | ⏳ 待开始  |
| 阶段四 | IO 流与异常处理 | ⏳ 待开始  |
| 阶段五 | 多线程与并发 | ⏳ 待开始  |
| 阶段六 | 网络编程 | ⏳ 待开始  |
| 阶段七 | 数据库与 JDBC | ⏳ 待开始  |
| 阶段八 | Spring Boot 入门 | ⏳ 待开始  |

## 目录结构

```
src/main/java/com/jianglai/learn/   练习代码,每个阶段一个包
   └── stage01/                      阶段一:基础语法
        └── HelloWorld.java          入门:类结构、main 入口、控制台输出

docs/参考实现/stage01/               阶段一的参考答案(自己先敲,卡住再看)
        ├── Variables.java           变量与八种基本数据类型、类型转换
        ├── Operators.java           运算符(含 + 拼接、自增自减、短路、位运算)
        ├── ScannerDemo.java         控制台输入 Scanner(含 nextInt/nextLine 陷阱)
        ├── BranchDemo.java          if / else if / switch(含箭头写法与 switch 表达式)
        ├── LoopDemo.java            for / while / do-while、break / continue
        ├── ArrayDemo.java           数组(遍历、Arrays 工具类、二维数组)
        └── MethodDemo.java          方法、重载、值传递、递归
```

> 练习方式:照 `docs/参考实现/stage01/` 里的文件名,自己在 `stage01` 包下敲一份,
> 编译运行对着预期输出检查。写不出来或想对答案时再去 `docs` 里看。

## 常用命令

```bash
mvn compile    # 编译
mvn test       # 跑测试(以后加了 JUnit 用)

# 编译后运行任意一个练习类(注意用"全限定类名":包名 + 类名)
java -cp target/classes com.jianglai.learn.stage01.Variables
```

> 在 IDEA 里更省事:打开任意一个类,点 `main` 方法左边的绿色三角直接运行。
