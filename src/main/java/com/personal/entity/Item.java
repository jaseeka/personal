package com.personal.entity;

import com.common.dao.BaseEntity;

import java.util.Date;

/**
 * ÊÂÏî
 * Created by jaseeka
 * Date 2015/8/16
 * Time 21:46
 */
public class Item extends BaseEntity{

    private Integer id;

    private String content;

    private Date time;

    private Integer state;

    private Boolean isDeleted;

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
