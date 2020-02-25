package Control;

import Dao.Page;
import Service.categoryservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SelectCategory",urlPatterns = "/selectcategory")
public class SelectCategory extends HttpServlet {
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

        categoryservice categoryservice1 = new categoryservice();
        Page page = categoryservice1.getPage(realpagenum);
        request.setAttribute("categorylist",page);
        request.getRequestDispatcher("manager/showcategory.jsp").forward(request,response);
        return;
    }
}
