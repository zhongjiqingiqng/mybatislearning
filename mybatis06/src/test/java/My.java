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
       // Teacher teacher = mapper.getTeacher(1);
      //  System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void Test1(){
        SqlSession sqlSession = MyUtiles.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudent();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    
    @Test
    public void Test2(){
        SqlSession sqlSession = MyUtiles.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudent2();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
