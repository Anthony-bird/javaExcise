package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;

public interface UserMapper {

    //查询全部用户
    List<User> getUserList();
    //根据id查询用户
    User getUserById(int id);


    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);


}
