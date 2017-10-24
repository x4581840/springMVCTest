package com.wisely.highlight_spring4.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wb-ljy189959 on 2017/7/7.
 */
@Controller //声明是一个控制器
public class HelloController {

    //配置URL和方法之间的映射
    @RequestMapping("/index")
    public String hello() {
        //通过上面ViewResolver的Bean配置，返回值为index，说明我们
        //的页面放置路径为/WEB-INF/class/views/index.jsp
        return "index";
    }
}
