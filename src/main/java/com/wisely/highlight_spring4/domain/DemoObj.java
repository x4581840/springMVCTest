package com.wisely.highlight_spring4.domain;

/**
 * Created by wb-ljy189959 on 2017/7/7.
 */
public class DemoObj {
    private Long id;
    private String name;

    //jackson对对象和json做转换时一定需要此空构造
    public DemoObj() {
        super();
    }

    public DemoObj(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
