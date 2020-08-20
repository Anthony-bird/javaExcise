package com.feng._07继承的使用案例;
// 父类（姓名，年龄。通用行为：吃饭）
public class People {
    private String name;
    private int age;

    public void eat(){
        System.out.println(name+", 在吃饭！");
    }

    public People() {
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
