package cn.com.polycis.modules.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class TokenInterceptor  implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(TokenInterceptor.class);


    /**
     * 进入controller层之前拦截请求
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
            throws Exception {
        httpServletRequest.setCharacterEncoding("UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/html;charset=utf-8");

        log.info("---------------------开始进入请求地址拦截----------------------------");

      /*  httpServletRequest.getSession().setAttribute("token", "456");
        return true;*/
       if(null !=httpServletRequest.getSession().getAttribute("token")){

           if("123".equals(httpServletRequest.getSession().getAttribute("token"))){
               return true;
           }
           // httpServletResponse.sendRedirect("http://localhost:8088/user/login");
           PrintWriter printWriter = httpServletResponse.getWriter();
           printWriter.write("{code:0,message:\"token过期,请重新登录!\"}");

           return false;

       }  else {
         //  httpServletResponse.sendRedirect("http://localhost:8088/user/login");
           PrintWriter printWriter = httpServletResponse.getWriter();
           printWriter.write("{code:0,message:\"请重新登录!\"}");
           return  false;
       }

    }



    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
       // log.info("--------------处理请求完成后视图渲染之前的处理操作---------------");

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
     //   log.info("---------------视图渲染之后的操作-------------------------0");
    }
}