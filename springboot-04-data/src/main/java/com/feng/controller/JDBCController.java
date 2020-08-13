package com.feng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;


    //List 中的1个 Map 对应数据库的 1行数据
    //Map 中的 key 对应数据库的字段名，value 对应数据库的字段值
    @GetMapping("/userList")
    public List<Map<String, Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    //新增一个用户
    @GetMapping("/addUser")
    public String addUser(){
        //插入语句
        String sql = "insert into mybatis.user(id, name, pwd) values (6,'小明','123456')";
        jdbcTemplate.update(sql);
        //查询
        return "addUser-ok";
    }

    //修改用户信息
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        //插入语句
        String sql = "update mybatis.user set name=?,pwd=? where id="+id;
        //数据
        Object[] objects = new Object[2];
        objects[0] = "小明2";
        objects[1] = "qwe";
        jdbcTemplate.update(sql,objects);
        //查询
        return "updateUser-ok";
    }

    //删除用户
    @GetMapping("/delUser/{id}")
    public String delUser(@PathVariable("id") int id){
        //插入语句
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql,id);
        //查询
        return "delUser-ok";
    }
}
