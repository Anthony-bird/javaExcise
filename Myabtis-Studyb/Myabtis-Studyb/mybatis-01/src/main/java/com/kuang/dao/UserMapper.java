package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserLike(String value);
    //查询全部用户
    List<User> getUserList();
    //根据id查询用户
    User getUserById(int id);

    User getUserById2(Map<String,Object> map);


    int addUser(User user);

    //万能的map
    int addUser2(Map<String,Object> map);

    int updateUser(User user);

    int deleteUser(int id);


}
