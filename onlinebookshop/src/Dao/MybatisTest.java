package Dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.sql.Connection;

public class MybatisTest {
    private static  ThreadLocal<SqlSession> sqlSession = new ThreadLocal<SqlSession>();
    private  static SqlSessionFactory sqlSessionFactory ;
    public void test()
    {
        InputStream inputStream = MybatisTest.class.getClassLoader().getResourceAsStream("/Dao/mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Connection conn = sqlSession.getConnection();
        System.out.println(conn);
    }

    static {
        InputStream inputStream = MybatisTest.class.getClassLoader().getResourceAsStream("/Dao/mybatis.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    public SqlSession getSqlSession()
    {
        SqlSession session = sqlSession.get();
        if(session==null)
        {
            sqlSession.set(sqlSessionFactory.openSession());
        }
        return sqlSession.get();
    }

    public  void closeSqlSession()
    {
        SqlSession session = sqlSession.get();
        if(session!=null)
        {
            sqlSession.get().close();
            sqlSession.remove();
        }
    }



}
