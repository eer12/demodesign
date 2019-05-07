package cn.com.polycis.modules.interceptor;



import cn.com.polycis.modules.user.entity.Users;
import org.springframework.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @date 2019.4.16
 */
public class LoginFilter implements Filter {



    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String path = req.getServletPath();

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        if (!path.endsWith("/login")){
               Users user = (Users) WebUtils.getSessionAttribute(req,"user");
        if (user == null){
            PrintWriter printWriter = response.getWriter();
            printWriter.write("{code:0,message:\"请登录!\"}");
           // resp.sendRedirect("/user/login");
            return;
        }
        RequestHolder.add(user);
        }

        /*Users user = (Users) WebUtils.getSessionAttribute(req,"user");
        RequestHolder.add(user);*/
        System.out.println("进入了拦截器,把request,response放入了threadlocal");
        RequestHolder.add(req);
        chain.doFilter(request,response);

        return;
    }

    @Override
    public void destroy() {

    }
}
