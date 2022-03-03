package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MyUtiles;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
  static   Logger logger = Logger.getLogger(UserDaoTest.class);


  @Test
  public void getUserByLimit(){
      SqlSession session = MyUtiles.getSqlSession();
      UserMapper mapper = session.getMapper(UserMapper.class);
      HashMap<String, Integer> map = new HashMap<String, Integer>();
      map.put("startIndex",0);
      map.put("pageSize",2);

      List<User> users = mapper.getUserByLimit(map);
      for (User user : users) {
          System.out.println(user);
      }
      session.close();
  }
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

    @Test
    public void testlog4j(){

    logger.info("info:进入了testlog4j");
    logger.debug("debug:今日了testlog4j");
    logger.error("error:今日了testlog4j");

        SqlSession sqlSession = MyUtiles.getSqlSession();
        UserMapper mapper1 = sqlSession.getMapper(UserMapper.class);
       User users= mapper1.getUserById(2);
        System.out.println(users);
        sqlSession.close();
    }


    @Test
    public void testQueryUserById(){
        SqlSession session = MyUtiles.getSqlSession();


        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);


        User user2 = mapper2.getUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);

        session.close();
    }

    @Test
    public void testQueryUserById1(){
        SqlSession session = MyUtiles.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);

        session.clearCache();//手动清除缓存

        User user2 = mapper.getUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);

        session.close();
    }
    @Test
    public void testQueryUserById2(){
        SqlSession session = MyUtiles.getSqlSession();
        SqlSession session2 = MyUtiles.getSqlSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);
        session.close();

        User user2 = mapper2.getUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);

        session2.close();
    }
}
