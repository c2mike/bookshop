package Service;

import Dao.Book;
import Dao.BookDao;
import Dao.Page;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookService {
    private BookDao bookDao = new BookDao();

    public void insertone(String name,String description,String author,String pic,String categoryname,float price)
    {
        Book book = new Book();
        book.setName(name);
        book.setDescription(description);
        book.setAuthor(author);
        book.setPic(pic);
        book.setCategoryname(categoryname);
        book.setPrice(price);

        bookDao.addbook(book);
    }

    public Book selectone(int id)
    {
        return bookDao.selectone(id);
    }

    public List<Book> selectall()
    {
        return bookDao.selectAll();
    }

    public Page getpage(int currentpagenum)  {
        Map<String,Integer> map = new HashMap<String,Integer>();
        if(currentpagenum<1)
        {
            currentpagenum = 1;
        }
        int start = (currentpagenum - 1)*2;
        int end = 2;
        map.put("start",start);
        map.put("size",end);
        int count = bookDao.getcount();
        List<Book> data = bookDao.getPageData(map);
        /*for(Book book:data)
        {
            String pic = book.getPic();
            if(pic!=null)
            {
                pic = URLDecoder.decode(pic,"UTF-8");
                System.out.println(pic);
            }
        }*/
        Page<Book> page = new Page<Book>(currentpagenum,count,data);
        return page;
    }

    public Page getpagedatabycategory(Map<String,Object> param)
    {
        int count = bookDao.getcount();
        List<Book> data = bookDao.getPageDataByCategory(param);
        Page<Book> page = new Page<Book>(1,count,data);
        return page;
    }

    public void deleteone(int id)
    {
        bookDao.deleteone(id);
    }

    public void updateone(int id,String name,String description,String author,String pic,String  categoryname,float price)
    {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setDescription(description);
        book.setAuthor(author);
        book.setPic(pic);
        book.setCategoryname(categoryname);
        book.setPrice(price);

        bookDao.updateone(book);
    }
}
