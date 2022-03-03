import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MyUtiles;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test(){


        SqlSession sqlSession = MyUtiles.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }

        User user1 = mapper.getUserById(1);
        System.out.println(user1);
        sqlSession.close();

    }

    @Test
    public void  test1(){
        SqlSession sqlSession = MyUtiles.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(3,"wo","1234"));
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MyUtiles.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(4,"晨","d12323"));

        mapper.updateUser(new User(6,"我","2222"));
        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MyUtiles.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(3);
        sqlSession.close();
    }
}
