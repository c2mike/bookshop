package Filter;

import Dao.User;
import Service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/client/head.jsp")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null)
        {
            String username = null,password = null;

            for(Cookie cookie:cookies)
            {
                if(cookie.getName().equals("username"))
                {
                    username = cookie.getValue();
                }
                if(cookie.getName().equals("password"))
                {
                    password = cookie.getValue();
                }
            }
            if (username != null && password != null) {

                UserService userService = new UserService();
                User user = userService.login(username,password);
                if(user!=null)
                {
                    userService.finduserprivilege(user);
                    HttpSession session = request.getSession();
                    session.setAttribute("user",user);
                    
                }
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
