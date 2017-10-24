package com.wisely.highlight_springmvc4;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by wb-ljy189959 on 2017/7/4.
 */
//WebApplicationInitializer是spring用来配置servlet3.0+配置的接口，
//从而实现了替代web.xml的位置，实现此接口将会自动被
//SpringServletContainerInitializer(用来启动servlet3.0容器)获取到。
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //新建WebApplicationContext，注册配置类，并和当前的servletcontext关联
        AnnotationConfigWebApplicationContext context =
            new AnnotationConfigWebApplicationContext();
        context.register(MyMvcConfig.class);
        context.setServletContext(servletContext);

        //注册Spring MVC的DispatcherServlet
        Dynamic servlet = servletContext.addServlet("dispatcher",
            new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
