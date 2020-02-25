package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@WebFilter(filterName = "AllSiteFilter",urlPatterns = "/*")
public class AllSiteFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        final HttpServletRequest request =(HttpServletRequest) req;
        HttpServletResponse response =(HttpServletResponse) resp;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
        response.setHeader("expires","0");

        chain.doFilter((ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(),
                request.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(!method.getName().equals("getRequestDispatcher")&&!method.getName().equals("sendRedirect"))
                        {
                            return method.invoke(request,args);
                        }
                        else
                        {
                            String str = response.encodeURL((String) args[0]);
                            return method.invoke(request,str);
                        }
                        /*
                        if(!method.getName().equals("getParameter"))
                        {
                            return method.invoke(request,args);
                        }
                        if(!request.getMethod().equalsIgnoreCase("get"))
                        {
                            return method.invoke(request,args);
                        }
                        String value = (String) method.invoke(request,args);
                        return value;
                        if(value==null)
                        {
                            return value;
                        }
                        return new String(value.getBytes("ISO-8859-1"),"utf-8");*/
                    }
                })
                , resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
