package com.company.spring5.aopanno;

import org.springframework.stereotype.Component;

//被增强的类
@Component
public class User {
    public void add(){
        int i=10/0;     //测试异常
        System.out.println("add...");
    }
}
