package Service;

import Dao.Book;

import java.util.*;

public class ShoppingCartService {
    //private Map<Integer,ShoppingItem> cart = new HashMap<Integer,ShoppingItem>();

    public void addshoppingitem(int id,Map<Integer,ShoppingItem> cart)
    {
        ShoppingItem shoppingItem = cart.get(id);
        if(shoppingItem==null)
        {
            BookService bookService = new BookService();
            Book book = bookService.selectone(id);
            ShoppingItem si = new ShoppingItem();
            si.setBook(book);
            si.setCount(1);
            cart.put(id,si);
        }
        else
        {
            shoppingItem.setCount(shoppingItem.getCount()+1);
        }
    }



    public float getprice(Map<Integer,ShoppingItem> cart)
    {
        float sum = 0;
        for(ShoppingItem item:cart.values())
        {
            sum += item.getCount()*item.getBook().getPrice();
        }
        return sum;
    }
}
