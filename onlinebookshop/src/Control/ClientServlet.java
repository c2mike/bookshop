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
import java.util.List;

@WebServlet(name = "ClientServlet",urlPatterns = "/clientservlet")
public class ClientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagenum = request.getParameter("pagenum");
        int realnum = 1;
        if(pagenum!=null&&!"".equals(pagenum))
        {
            realnum = Integer.parseInt(pagenum);
        }
        categoryservice categoryservice = new categoryservice();
        List<Category> categories = categoryservice.selectall();
        BookService bookService = new BookService();
        Page<Book> page = bookService.getpage(realnum);
        request.setAttribute("categories",categories);
        request.setAttribute("page",page);
        request.getRequestDispatcher("client/body.jsp").forward(request,response);
    }
}
