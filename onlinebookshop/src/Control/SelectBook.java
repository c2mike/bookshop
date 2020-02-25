package Control;

import Dao.Page;
import Service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SelectBook",urlPatterns = "/selectbook")
public class SelectBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagenum = request.getParameter("pagenum");
        int realpagenum = 1;
        if(pagenum!=null)
        {
            realpagenum = Integer.parseInt(pagenum);
            if(realpagenum<1)
            {
                realpagenum = 1;
            }
        }

        BookService categoryservice1 = new BookService();
        Page page = categoryservice1.getpage(realpagenum);
        request.setAttribute("bookpage",page);
        String baser_dir = request.getServletContext().getRealPath("/upload");
        request.setAttribute("base_dir",request.getServletContext().getRealPath("/upload"));
        request.getRequestDispatcher("manager/showbook.jsp").forward(request,response);
        return;
    }
}
