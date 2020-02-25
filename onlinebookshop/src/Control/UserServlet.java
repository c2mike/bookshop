package Control;

import Dao.User;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@WebServlet(name = "UserServlet",urlPatterns = "/userservlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String randomstr = request.getParameter("randomstr");
        HttpSession session = request.getSession();
        String randomstrservice = (String) session.getAttribute("randomstr");
        if(randomstrservice==null||randomstr==null||!randomstr.equals(randomstrservice))
        {
            request.setAttribute("message","不要重复提交");
            request.getRequestDispatcher("message.jsp").forward(request,response);
            return;
        }
        session.removeAttribute("randomstr");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        password = md5digest(password);
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        UserService userService = new UserService();
        try{
            userService.adduser(username,password,address,email,phone);
            request.setAttribute("message","注册成功");
        }
        catch (Exception e)
        {
            request.setAttribute("message","命名重复");
        }
        request.getRequestDispatcher("message.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String func = request.getParameter("func");
        HttpSession session = request.getSession();
        if("login".equals(func))
        {
            String password = request.getParameter("password");
            String username = request.getParameter("username");
            String checkstr = request.getParameter("checkstr");
            String checkstrservice = (String) session.getAttribute("randomstr");
            if(checkstr==null||checkstrservice==null||!checkstr.equals(checkstrservice))
            {
                request.setAttribute("message","验证码错误");
                request.getRequestDispatcher("message.jsp").forward(request,response);
                return;
            }
            UserService userService = new UserService();
            password = md5digest(password);
            User user = userService.login(username,password);
            if(user==null)
            {
                request.setAttribute("message","账号或者密码错误");
                request.getRequestDispatcher("message.jsp").forward(request,response);
                return;
            }
            else
            {
                Cookie cookie = new Cookie("username",""+user.getUsername());
                Cookie cookie1 = new Cookie("password",user.getPassword());
                cookie1.setMaxAge(30*60);
                cookie.setMaxAge(30*60);
                userService.finduserprivilege(user);
                session.setAttribute("user",user);
                response.addCookie(cookie);
                response.addCookie(cookie1);
                request.setAttribute("message","登录成功");
                request.getRequestDispatcher("message.jsp").forward(request,response);
                return;
            }
        }
        else if("register".equals(func))
        {
            session.setAttribute("randomstr",getrandomstr());
            request.getRequestDispatcher("client/register.jsp").forward(request,response);
            return;
        }
        else if("quit".equals(func))
        {
            session.removeAttribute("user");
            request.setAttribute("message","成功退出");
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }
    }

    private String getrandomstr() {
        String value = ""+System.currentTimeMillis()+new Random().nextInt(9999);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(value.getBytes());
            char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
            StringBuilder builder = new StringBuilder();
            for(int i = 0;i<digest.length;i++)
            {
                byte b = digest[i];
                char c1 = chars[(b>>4)&15];
                char c2 = chars[b&15];
                builder.append(c1).append(c2);
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String md5digest(String str)
    {
        String value = str;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(value.getBytes());
            char[] chars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
            StringBuilder builder = new StringBuilder();
            for(int i = 0;i<digest.length;i++)
            {
                byte b = digest[i];
                char c1 = chars[(b>>4)&15];
                char c2 = chars[b&15];
                builder.append(c1).append(c2);
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return value;
    }
}
