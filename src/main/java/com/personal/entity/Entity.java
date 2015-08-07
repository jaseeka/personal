package com.personal.entity;

import com.common.dao.BaseEntity;

/**
 * 基础测试类
 * Created by jaseeka
 * Date 2015/8/6
 * Time 15:51
 */
public class Entity extends BaseEntity {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
