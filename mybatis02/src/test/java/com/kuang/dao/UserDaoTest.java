package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MyUtiles;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void test(){
            // 1 获取sqlsession对象
        SqlSession sqlSession= MyUtiles.getSqlSession();

        //方式一 ：getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userDao.getUserList();

        for(User user:userList){
            System.out.println(user);
        }


        //关闭sqlsession
        sqlSession.close();
    }


}
