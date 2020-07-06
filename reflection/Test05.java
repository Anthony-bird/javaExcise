package com.kuang.reflection;

public class Test05 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);

        /*
        * 1.加载到内存，会产生对应的class对象
        * 2.链接，结束后 m=0
        * 3.初始化
        *   <clinit>(){
        *       System.out.println("A类静态代码初始化");
                m=300;
        * }
        * m = 100
        * */
    }
}

class A{
    static {
        System.out.println("A类静态代码初始化");
        m=300;
    }
    static int m = 100;

    public A() {
        System.out.println("A类的无参构造初始化");
    }
}

