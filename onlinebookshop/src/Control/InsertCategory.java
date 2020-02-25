package Control;

import Service.categoryservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertCategory",urlPatterns = "/insertcategory")
public class InsertCategory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        categoryservice categoryservice1 = new categoryservice();
        try{
            categoryservice1.insert(name,description);
            request.setAttribute("message","插入成功");
        }
        catch (Exception e)
        {
            request.setAttribute("message","插入失败");
            e.printStackTrace();
        }
        request.getRequestDispatcher("message.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("manager/addcategory.jsp").forward(request,response);
    }
}
