package com.company.spring5;

/*
* 演示使用set方法注入属性
* */
public class Book {
    private String bauthor;
    private String bname;

    //set方法注入
    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }


    public  void testDemo() {
        System.out.println(bname+"::"+bauthor);
    }
}
