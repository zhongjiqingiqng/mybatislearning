package java;

import com.kuang.dao.StudentMapper;
import com.kuang.dao.TeacherMapper;
import com.kuang.pojo.Student;
import com.kuang.pojo.Teacher;
import com.kuang.utils.MyUtiles;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class My {
    public static void main(String[] args) {

        SqlSession sqlSession = MyUtiles.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeacher();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    @Test
    public void testGetTeacher(){
        SqlSession sqlSession = MyUtiles.getSqlSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeacher();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
      sqlSession.close();
    }
}