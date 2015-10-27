package com.personal.entity;

import com.common.dao.BaseEntity;

import java.util.Date;

/**
 * ¼Æ»®
 * Created by jaseeka
 * Date 2015/8/16
 * Time 21:49
 */
public class Plan extends BaseEntity {

    private Integer id;

    private String content;

    private Boolean isCycle;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getIsCycle() {
        return isCycle;
    }

    public void setIsCycle(Boolean isCycle) {
        this.isCycle = isCycle;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
