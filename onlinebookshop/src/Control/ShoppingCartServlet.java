package Control;

import Service.ShoppingCartService;
import Service.ShoppingItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ShoppingCartServlet",urlPatterns = "/shoppingcartservlet")
public class ShoppingCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String func=request.getParameter("func");
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        if("buy".equals(func))
        {
            String id = request.getParameter("id");
            int realid = Integer.parseInt(id);
            HttpSession session = request.getSession();
            Map<Integer, ShoppingItem> cart = (Map<Integer, ShoppingItem>) session.getAttribute("cart");
            if(cart==null)
            {
                cart = new HashMap<Integer,ShoppingItem>();
            }
            shoppingCartService.addshoppingitem(realid,cart);
            session.setAttribute("cart",cart);
            request.setAttribute("message","添加成功");
            request.getRequestDispatcher("message.jsp").forward(request,response);
            return;
        }
        else if("showcart".equals(func))
        {
            request.getRequestDispatcher("client/showcart.jsp").forward(request,response);
            return;
        }
        else if("clear".equals(func))
        {
            HttpSession session = request.getSession();
            session.removeAttribute("cart");
            request.setAttribute("message","清空成功");
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }
    }
}
