package cn.com.polycis.modules.interceptor.MethodIntecptor.annotation;

import cn.com.polycis.modules.interceptor.TokenIntecptor2;
import cn.com.polycis.modules.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*
*
 *
 * 注册拦截器
 *

*/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addWebRequestInterceptor(new GlobalTransactionalInterceptor());
   }
