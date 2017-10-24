package com.wisely.highlight_spring4.web.ch4_3;

import com.wisely.highlight_spring4.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wb-ljy189959 on 2017/7/7.
 */
@RestController //声明是控制器，并且返回数据时不需要@ResponseBody
@RequestMapping("/rest")
public class DemoRestController {

    //返回数据的媒体类型是json
    @RequestMapping(value = "/getJson", produces = "application/json,charset=UTF-8")
    public DemoObj getJson(DemoObj obj){
        //直接返回对象，对象会自动转换成xml
        return new DemoObj(obj.getId()+1, obj.getName()+"yy");
    }

    //返回数据的媒体类型是json
    @RequestMapping(value = "/getXml", produces = "application/xml,charset=UTF-8")
    public DemoObj getXml(DemoObj obj){
        //直接返回对象，对象会自动转换成xml
        return new DemoObj(obj.getId()+1, obj.getName()+"yy");
    }
}
