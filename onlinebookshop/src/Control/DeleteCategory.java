package Control;

import Service.categoryservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCategory",urlPatterns = "/deletecategory")
public class DeleteCategory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try{
            int realid = Integer.parseInt(id);
            categoryservice categoryservice1 = new categoryservice();
            categoryservice1.delete(realid);
            request.setAttribute("message","删除成功");
        }
        catch (Exception e)
        {
            request.setAttribute("message","删除失败");
            e.printStackTrace();
        }
        request.getRequestDispatcher("message.jsp").forward(request,response);
    }
}
