package Control;

import Service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteBook",urlPatterns = "/deletebook")
public class DeleteBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        BookService bookService = new BookService();
        try{
            bookService.deleteone(Integer.parseInt(id));
            request.setAttribute("message","成功删除");
        }
        catch (Exception e)
        {
            request.setAttribute("message","删除失败");

        }
        request.getRequestDispatcher("message.jsp").forward(request,response);
    }
}
