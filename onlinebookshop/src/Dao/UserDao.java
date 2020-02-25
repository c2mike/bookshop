package Dao;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class UserDao {
    private MybatisTest mybatisTest = new MybatisTest();

    public void insertone(User user)
    {
        SqlSession sqlSession = mybatisTest.getSqlSession();
        sqlSession.insert("user.insertone",user);
        sqlSession.commit();
    }

    public List<User> selectall(Map<String,String> param)
    {
        SqlSession sqlSession = mybatisTest.getSqlSession();
        return sqlSession.selectList("user.selectone",param);
    }

    public void selectprivilege(User user)
    {
        SqlSession sqlSession = mybatisTest.getSqlSession();
        String privilege = sqlSession.selectOne("user.selectprivilege",user.getId());
        user.setPrivilege(privilege);
    }
}
