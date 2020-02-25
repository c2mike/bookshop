package Dao;

import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private MybatisTest mybatisTest = new MybatisTest();
    public void insertone(Order order)
    {
        SqlSession sqlSession = mybatisTest.getSqlSession();
        sqlSession.insert("order.insertone",order);
        sqlSession.commit();
        int id = order.getId();
        for(OrderItem orderItem:order.getItems()) {
            orderItem.setOrderid(id);
        }
        sqlSession.insert("order.insertitems",order.getItems());
        sqlSession.commit();
    }

    public Order selectorderbyorderid(int id)
    {
        SqlSession sqlSession = mybatisTest.getSqlSession();
        Order order = sqlSession.selectOne("order.selectbyorderid",id);
        order.setItems(sqlSession.selectList("order.selectorderitem",id));
        return order;
    }

    public List<Order> selectorderbyuserid(int id)
    {
        List<Order> orders = null;
        SqlSession sqlSession = mybatisTest.getSqlSession();
        orders = sqlSession.selectList("order.selectbyuserid",id);
        for(Order order:orders)
        {
            int orderid = order.getId();
            order.setItems(sqlSession.selectList("order.selectorderitem",orderid));
        }
        return orders;
    }

    public void updateone(Order order)
    {
        SqlSession sqlSession = mybatisTest.getSqlSession();
        sqlSession.update("order.updateone",order);
    }
}
