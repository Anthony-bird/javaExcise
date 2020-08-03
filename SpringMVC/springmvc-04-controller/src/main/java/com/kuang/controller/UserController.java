package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        //封装要显示到视图中的数据
        //相当于req.setAttribute("name",name);
        //1接收前端参数
        System.out.println("接收到的前端参数为:" + name);
        model.addAttribute("msg",name);

        return "test";
    }

    /*
    * 1.接收前端用户传递参数，判断参数的名字，假设名字直接在方法上，可以直接使用
    * 2.假设传递的是一个对象User，匹配User对象中的字段名：如果一直则OK，否者为null*/
    @GetMapping("/t2")
    public String test2(User user){

        System.out.println(user);

        return "test";
    }
}
