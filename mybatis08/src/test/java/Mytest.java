import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IDutils;
import com.kuang.utils.MyUtiles;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Mytest {
   @Test
    public void addBlog(){

       SqlSession sqlSession = MyUtiles.getSqlSession();
       BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);


       Blog blog = new Blog();
       blog.setId(IDutils.getId());
       blog.setTitle("Mybatis如此简单");
       blog.setAuthor("狂神说");
       blog.setCreateTime(new Date());
       blog.setViews(9999);

       mapper.addBlog(blog);

       blog.setId(IDutils.getId());
       blog.setTitle("Java如此简单");
       mapper.addBlog(blog);

       blog.setId(IDutils.getId());
       blog.setTitle("Spring如此简单");
       mapper.addBlog(blog);

       blog.setId(IDutils.getId());
       blog.setTitle("微服务如此简单");
       mapper.addBlog(blog);

       sqlSession.close();
   }


   @Test
   public void testQueryBlogIf(){
      SqlSession session = MyUtiles.getSqlSession();
      BlogMapper mapper = session.getMapper(BlogMapper.class);
      HashMap<String, String> map = new HashMap<String, String>();

      map.put("title","Mybatis如此简单");
      map.put("author","狂神说");
      List<Blog> blogs = mapper.queryBlogIf(map);

      System.out.println(blogs);

      session.close();
   }

   @Test
   public void testUpdateBlog(){
      SqlSession session = MyUtiles.getSqlSession();
      BlogMapper mapper = session.getMapper(BlogMapper.class);

      HashMap<String, String> map = new HashMap<String, String>();
      map.put("title","动态SQL333");
      map.put("author","秦疆");
      map.put("id","9d6a763f5e1347cebda43e2a32687a77");

      mapper.updateBlog(map);

   session.commit();
      session.close();
   }

   @Test
   public void testQueryBlogChoose(){
      SqlSession session = MyUtiles.getSqlSession();
      BlogMapper mapper = session.getMapper(BlogMapper.class);

      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("title","Java如此简单");
      map.put("author","狂神说");
      map.put("views",9999);
      List<Blog> blogs = mapper.queryBlogChoose(map);

      System.out.println(blogs);

      session.close();
   }
}
