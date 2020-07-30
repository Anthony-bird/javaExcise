package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

        @Test
        public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = mapper.getUsers();
//        for (User user : users) {
//            System.out.println(user);
//        }

        User userByID = mapper.getUserByID(1);
        System.out.println(userByID);

//        mapper.addUser(new User(6,"Hello","123123"));

//        mapper.updateUser(new User(6,"to","21312"));

//        mapper.deleteUser(6);
        sqlSession.close();


    }
}


