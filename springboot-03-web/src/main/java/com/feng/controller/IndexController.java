package com.feng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/test")
    public String index(Model model){
        model.addAttribute("msg","hello,springboot");
        return "test";
    }
}
