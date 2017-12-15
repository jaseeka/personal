package com.personal.entity;

import com.common.dao.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by jaseeka
 * Date 2016/1/21
 * Time 15:30
 */
@Data
public class Note extends BaseEntity {

    private Integer id;

    private Integer userId;

    private String content;

    private Date time;

    private Boolean isDeleted;
}
