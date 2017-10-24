package com.wisely.highlight_spring4.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Created by wb-ljy189959 on 2017/7/14.
 */
//继承HandlerInterceptorAdapter来实现自定义拦截器
public class DemoInterceptor extends HandlerInterceptorAdapter{

    //重写preHandle方法，在请求发生前执行
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
        throws Exception {
        //return super.preHandle(request, response, handler);
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    //重写postHandle方法，在请求完成后执行
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        //super.postHandle(request, response, handler, modelAndView);
        long startTime = (Long)request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("本次请求处理时间为：" + new Long(endTime - startTime) + "ms");
        request.setAttribute("handingTime", endTime-startTime);
    }
}
