package Control;

import Dao.Book;
import Dao.Category;
import Dao.Page;
import Service.BookService;
import Service.categoryservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "GetBookByCategory",urlPatterns = "/getbookbycategory")
public class GetBookByCategory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("name");
        int currentpagenum = 1;
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("start",0);
        param.put("end",2);
        param.put("name",id);
        BookService bookService = new BookService();

        Page<Book> page = bookService.getpagedatabycategory(param);
        categoryservice categoryservices = new categoryservice();
        List<Category> categories = categoryservices.selectall();

        request.setAttribute("categories",categories);
        request.setAttribute("page",page);

        request.getRequestDispatcher("client/body.jsp").forward(request,response);
    }
}
