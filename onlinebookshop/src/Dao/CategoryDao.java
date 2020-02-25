package Dao;

import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDao {

    public void addcategory(Category category)
    {
        MybatisTest mybatisTest = new MybatisTest();
        SqlSession sqlSession = mybatisTest.getSqlSession();
        sqlSession.insert("category.add",category);
        sqlSession.commit();
        mybatisTest.closeSqlSession();
    }

    public Category findcategory(int id)
    {
        MybatisTest mybatisTest = new MybatisTest();
        SqlSession sqlSession = mybatisTest.getSqlSession();
        return sqlSession.selectOne("category.find",id);
    }

    public List<Category> getallcategory()
    {
        MybatisTest mybatisTest = new MybatisTest();
        SqlSession sqlSession = mybatisTest.getSqlSession();
        return sqlSession.selectList("category.findall");
    }

    public void deletecategory(int id)
    {
        MybatisTest mybatisTest = new MybatisTest();
        mybatisTest.getSqlSession().delete("category.del",id);
        mybatisTest.getSqlSession().commit();
    }

    public void updatecategory(Category category)
    {
        MybatisTest mybatisTest = new MybatisTest();
        mybatisTest.getSqlSession().update("category.update",category);
        mybatisTest.getSqlSession().commit();
    }

    public int getcount()
    {
        MybatisTest mybatisTest = new MybatisTest();
        return mybatisTest.getSqlSession().selectOne("category.count");
    }

    public List<Category> getpagedata(int start, int end)
    {
        MybatisTest mybatisTest = new MybatisTest();
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("start",start);
        map.put("end",end);
        return mybatisTest.getSqlSession().selectList("category.selectpagedata",map);
    }


}
