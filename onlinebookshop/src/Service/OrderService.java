package Service;

import Dao.Order;
import Dao.OrderDao;
import Dao.OrderItem;
import Dao.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderService {
    private OrderDao orderDao = new OrderDao();

    public void makeorder(User user, Map<Integer,ShoppingItem> cart)
    {
        Order order = new Order();
        order.setUserid(user.getId());
        order.setDate((int) (System.currentTimeMillis()/1000));
        order.setState("未支付");
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        order.setPrice(shoppingCartService.getprice(cart));
        List<OrderItem> orderitems = new ArrayList<OrderItem>();
        for(ShoppingItem shoppingItem:cart.values())
        {
            OrderItem orderItem = new OrderItem();
            orderItem.setBookid(shoppingItem.getBook().getId());
            orderItem.setCount(shoppingItem.getCount());
            orderItem.setPrice(shoppingItem.getCount()*shoppingItem.getBook().getPrice());
            orderitems.add(orderItem);
        }
        order.setItems(orderitems);
        orderDao.insertone(order);
    }

    public List<Order> selectorderbyuserid(int id)
    {
       return orderDao.selectorderbyuserid(id);
    }

    public Order getorderbuorderid(int id)
    {
        return orderDao.selectorderbyorderid(id);
    }

    public void updateorder(Order order)
    {
        orderDao.updateone(order);
    }
}
