package com.kuang.annotation;

import java.util.ArrayList;
import java.util.List;

//什么是注解
@SuppressWarnings("all")
public class Test01 extends Object{

    //@Override 重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    //@Deprecated  不推荐使用，但可以使用，或存在更好的方式
    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }
    @SuppressWarnings("all")

    public void test02(){}
    List list =new ArrayList();

    public static void main(String[] args) {
        test();
    }
}
