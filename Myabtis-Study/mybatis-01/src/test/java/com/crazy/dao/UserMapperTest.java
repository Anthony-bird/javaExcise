package com.crazy.dao;

import com.crazy.pojo.User;
import com.crazy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void Test() {
            //第一步：获得SqlSession对象
            SqlSession sqlSession = MybatisUtils.getSqlSession();

            try {
                //方式一:getMapper
                UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
                List<User> userList = userMapper.getUserList();

//              List<User> userList = sqlSession.selectList("com.crazy.dao.UserMapper.getUserList");
                for (User user : userList) {
                    System.out.println(user);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                //关闭sqlSession
                sqlSession.close();
            }



        }

    @Test
    public void getUserById() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();


        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);


        sqlSession.close();
        }




    }


/*可能遇到的错误 1 配置文件没有注册 2 绑定接口错误 3 方法名不对 4 返回类型不对*/