package com.feng._17引用类型作为成员变量的类型;

/**
 目标：引用类型作为成员变量的类型（复合类型）。
 */
public class TestDemo {
    public static void main(String[] args) {
        Student x = new Student();
        x.setName("小明");
        x.setAge(19);
        Address addr = new Address("110","天河区吉山村",98,99);
        x.setAddress(addr);

        Address add1 = x.getAddress();
        System.out.println(add1.getCode()+"-->"+add1.getName());
        System.out.println(add1.getX());
        System.out.println(x.getName());
        System.out.println(x.getAge());
    }
}
