package com.feng;

import com.feng.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringbootApplicationTests {
    @Autowired
    UserServiceImpl userService;
    @Test
    void contextLoads() {
        System.out.println(userService.queryUserByName("李四"));
    }

}
