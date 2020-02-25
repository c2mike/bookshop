package Dao;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class BookDao {
    private  MybatisTest mybatisTest = new MybatisTest();

    public int getcount()
    {
    SqlSession sqlSession = mybatisTest.getSqlSession();
    return sqlSession.selectOne("book.count");
    }

    public void addbook(Book book)
    {
        SqlSession sqlSession = mybatisTest.getSqlSession();
        sqlSession.insert("book.insert",book);
        sqlSession.commit();
    }

    public Book selectone(int id)
    {
        SqlSession sqlSession = mybatisTest.getSqlSession();
        return sqlSession.selectOne("book.selectone",id);
    }

    public List<Book> selectAll()
    {
        SqlSession sqlSession = mybatisTest.getSqlSession();
        return  sqlSession.selectList("book.selectall");
    }

    public List<Book> getPageData(Map<String,Integer> map)
    {
        SqlSession sqlSession = mybatisTest.getSqlSession();
        return sqlSession.selectList("book.selectpagedata",map);
    }

    public List<Book> getPageDataByCategory(Map<String,Object> map)
    {
        SqlSession sqlSession = mybatisTest.getSqlSession();
        return sqlSession.selectList("book.selectpagedatabycategory",map);
    }

    public void deleteone(int id)
    {
        SqlSession sqlSession = mybatisTest.getSqlSession();
        sqlSession.delete("book.deleteone",id);
        sqlSession.commit();
    }

    public void updateone(Book book)
    {
        SqlSession sqlSession = mybatisTest.getSqlSession();
        sqlSession.update("book.updateone",book);
        sqlSession.commit();
    }
}
