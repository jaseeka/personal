package com.personal.entity;

import com.common.annotation.NoColumn;
import com.common.dao.BaseEntity;

import java.util.Date;

/**
 * 事项
 * Created by jaseeka
 * Date 2015/8/16
 * Time 21:46
 */
public class Item extends BaseEntity{

    private Integer id;

    private Integer userId;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
