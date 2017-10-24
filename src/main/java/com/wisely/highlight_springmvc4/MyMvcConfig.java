package com.wisely.highlight_springmvc4;

import com.wisely.highlight_spring4.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by wb-ljy189959 on 2017/7/4.
 */
@Configuration
//@EnableWebMvc会开启一些默认配置，如一些ViewResolver或者MessageConverter
//若无此句，重写方法WebMvcConfigurerAdapter无效
@EnableWebMvc
@ComponentScan("com.wisely.highlight_springmvc4")
//继承WebMvcConfigurerAdapter类，重写其方法可对SpringMVC进行配置
public class MyMvcConfig extends WebMvcConfigurerAdapter{

    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
            new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix("jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //super.addResourceHandlers(registry);
        //addResourceHandler指的是对外暴露的访问路径
        //addResourceLocations指的是文件放置的目录
        registry.addResourceHandler("/assets/**")
            .addResourceLocations("classpath:/assets/");
    }

    //配置拦截器的Bean
    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    //重写addInterceptors方法，注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
        registry.addInterceptor(demoInterceptor());
    }
}
