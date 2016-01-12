package com.personal.entity;

import com.common.dao.BaseEntity;

import java.util.Date;

/**
 * �ƻ�
 * Created by jaseeka
 * Date 2015/8/16
 * Time 21:49
 */
public class Plan extends BaseEntity {

    private Integer id;

    private Integer userId;

    private String content;

    private Integer cycleNum;

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

    public Integer getCycleNum() {
        return cycleNum;
    }

    public void setCycleNum(Integer cycleNum) {
        this.cycleNum = cycleNum;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
