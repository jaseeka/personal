package com.personal.entity;

import com.common.dao.BaseEntity;

import java.util.Date;

/**
 * Created by jaseeka
 * Date 2015/11/16
 * Time 8:36
 */
public class RegularDeposit extends BaseEntity{

    private Integer id;

    private String content;

    private Integer number;

    private Integer cycleNum;

    private Boolean isDeleted;

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCycleNum() {
        return cycleNum;
    }

    public void setCycleNum(Integer cycleNum) {
        this.cycleNum = cycleNum;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
