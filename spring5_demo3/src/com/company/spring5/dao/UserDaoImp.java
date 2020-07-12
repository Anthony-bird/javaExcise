package com.company.spring5.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "userDaoImp1")
public class UserDaoImp implements UserDao
{
    @Override
    public void add() {
        System.out.println("dao add..");
    }
}
