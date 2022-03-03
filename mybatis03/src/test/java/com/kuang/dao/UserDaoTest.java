package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MyUtiles;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
            // 1 获取sqlsession对象
        SqlSession sqlSession= MyUtiles.getSqlSession();

        //方式一 ：getMapper
        UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
User user=userMapper.getUserById(1);
        System.out.println(user);



        //关闭sqlsession
        sqlSession.close();
    }


}
