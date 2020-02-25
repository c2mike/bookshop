package Control;

import Service.categoryservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateCategory",urlPatterns = "/updatecategory")
public class UpdateCategory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        try{
            int realid = Integer.parseInt(id);
            categoryservice categoryservice1 = new categoryservice();
            categoryservice1.update(realid,name,description);
            request.setAttribute("message","修改成功");
        }
        catch (Exception e)
        {
            request.setAttribute("message","修改失败");
            e.printStackTrace();
        }
        request.getRequestDispatcher("message.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id",id);
        request.getRequestDispatcher("manager/updatecategory.jsp").forward(request,response);
    }
}
