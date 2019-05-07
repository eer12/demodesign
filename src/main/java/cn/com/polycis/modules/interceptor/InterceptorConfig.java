package cn.com.polycis.modules.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * 注册拦截器
 *
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login");
        registry.addInterceptor(new TokenIntecptor2()).addPathPatterns("/**").excludePathPatterns("/user/login");
        }
   }