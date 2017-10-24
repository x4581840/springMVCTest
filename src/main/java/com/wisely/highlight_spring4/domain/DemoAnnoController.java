package com.wisely.highlight_spring4.domain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wb-ljy189959 on 2017/7/7.
 */
@Controller //声明此类事一个控制器
@RequestMapping("/anno") //映射此类的访问路径是/anno
public class DemoAnnoController {

    //此方法未标注路径，因此使用类级别的路径/anno,
    //produces可定制返回的response的媒体类型和字符集，
    //或需返回值是json对象，则设置
    //produces="application/json,charset=UTF-8"
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access";
    }

    //访问路径为/anno/pathvar/xx
    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String demoPathVar(@PathVariable String str,
                                           HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access,str:" + str;
    }

    //演示常规的request参数获取，访问路径为/anno/requestPararm?id=1
    @RequestMapping(value = "/requestParam", params = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequstParam(Long id, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access,id:" + id;
    }

    //演示解释参数到对象，访问路径为/anno/obj?id=1&name=xx
    @RequestMapping(value = "/obj", params = "text/plain;charset=UTF-8")
    @ResponseBody
    public String passObj(DemoObj obj, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access, obj id:"
            + obj.getId() + " obj name:" + obj.getName();
    }

    //演示映射不同的路径到相同的方法，访问路径为/anno/name1或者/anno/name2
    @RequestMapping(value = {"/name1", "/name2"}, params = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(Long id, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access";
    }
}
