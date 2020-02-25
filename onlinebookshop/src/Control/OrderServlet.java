package Control;

import Dao.Order;
import Dao.User;
import Service.OrderService;
import Service.ShoppingItem;
import Util.PaymentUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OrderServlet",urlPatterns = "/orderservlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ordernum = request.getParameter("ordernum");
        String money = request.getParameter("money");
        String pd_FrpId = request.getParameter("pd_FrpId");

        String p0_Cmd = "Buy";
        String p1_MerId = "10001126856";
        String p2_Order = ordernum;
        String p3_Amt = money;
        String p4_Cur = "CNY";
        String p5_Pid = "unknown";
        String p6_Pcat = "unknown";
        String p7_Pdesc = "descrition";
        String p8_Url = "http://localhost:8080/bookshop"+"/responsepayservlet";
        String p9_SAF = "1";
        String pa_MP = "unknown";
        String pr_NeedResponse="1";
        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur,
                p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse,
                "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl");

        request.setAttribute("p0_Cmd",p0_Cmd );
        request.setAttribute("p1_MerId",p1_MerId );
        request.setAttribute("p2_Order", p2_Order);
        request.setAttribute("p3_Amt", p3_Amt);
        request.setAttribute("p4_Cur",p4_Cur );
        request.setAttribute("p5_Pid",p5_Pid );
        request.setAttribute("p6_Pcat",p6_Pcat );
        request.setAttribute("p7_Pdesc",p7_Pdesc );
        request.setAttribute("p8_Url",p8_Url );
        request.setAttribute("pa_MP",pa_MP );
        request.setAttribute("pr_NeedResponse",pr_NeedResponse );
        request.setAttribute("hmac",hmac );
        request.setAttribute("p9_SAF",p9_SAF );
        request.setAttribute("pd_FrpId", pd_FrpId);

        request.getRequestDispatcher("client/sure.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String func = request.getParameter("func");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null)
        {
            request.setAttribute("message","请先登录");
            request.getRequestDispatcher("message.jsp").forward(request,response);
            return;
        }
        Map<Integer, ShoppingItem> cart = (Map<Integer, ShoppingItem>) session.getAttribute("cart");
        if("makeorder".equals(func))
        {
            if(cart==null||cart.size()==0)
            {
                request.setAttribute("message","购物车为空");
                request.getRequestDispatcher("message.jsp").forward(request,response);
                return;
            }
            else
            {
                OrderService orderService = new OrderService();
                orderService.makeorder(user,cart);
                session.removeAttribute("cart");
                request.setAttribute("message","下单成功");
                request.getRequestDispatcher("message.jsp").forward(request,response);
                return;
            }
        }
        else if("showorder".equals(func))
        {
            int userid = user.getId();
            OrderService orderService = new OrderService();
            List<Order> orders = orderService.selectorderbyuserid(userid);
            request.setAttribute("orders",orders);
            request.getRequestDispatcher("client/showorder.jsp").forward(request,response);
            return;
        }
        else if("pay".equals(func))
        {
            String id = request.getParameter("orderid");
            int realid = Integer.parseInt(id);
            OrderService orderService = new OrderService();
            Order order = orderService.getorderbuorderid(realid);
            request.setAttribute("orderid",id);
            request.setAttribute("price",order.getPrice());
            request.getRequestDispatcher("client/pay.jsp").forward(request,response);
            return;
        }
        else if("showorderdetail".equals(func))
        {
            String id = request.getParameter("orderid");
            int realid = Integer.parseInt(id);
            OrderService orderService = new OrderService();
            Order order = orderService.getorderbuorderid(realid);
            request.setAttribute("order",order);
            request.getRequestDispatcher("client/showorderdetail.jsp").forward(request,response);
            return;
        }
    }
}
