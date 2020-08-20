package com.feng._07继承的使用案例;

/**
 目标：继承的使用案例。

 案例（教务系统）
 学生类（姓名，年龄，吃饭，特有功能：学习）
 老师类（姓名，年龄，吃饭，特有功能：授课）
 班主任（姓名，年龄，吃饭，特有功能：管理）

 问题：
 如果直接定义类会出现大量相同属性相同行为的重复代码。
 企业开发中不允许太多冗余代码。
 解决思路：
 把相同的属性和行为定义在一个父类中，然后让子类继承即可。

 父类：People类(姓名，年龄，吃饭)
 学生类（特有功能：学习）
 老师类（特有功能：授课）
 班主任（特有功能：管理）

 小结：
 继承的优势可以把相同的代码定义在父类中，子类可以直接继承使用。
 这样就可以提高代码的复用性：相同代码只需要在父类中写一次就可以了。
 */
public class TestMain {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.setName("哈哈"); // 调用继承自父类的
        t1.setAge(18); // 调用继承自父类的
        System.out.println(t1.getName()); // 调用继承自父类的
        System.out.println(t1.getAge()); // 调用继承自父类的
        t1.eat(); // 调用继承自父类的
        t1.teach(); // 调用子类自己的！

        Student s1 = new Student();
        s1.setName("bb");
        s1.setAge(10);
        System.out.println(s1.getName());
        System.out.println(s1.getAge());
        s1.eat();
        s1.study();
    }
}
