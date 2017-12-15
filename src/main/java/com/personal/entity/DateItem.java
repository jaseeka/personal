package com.personal.entity;

import com.common.dao.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Administrator on 2016/7/31.
 */
@Data
public class DateItem extends BaseEntity {

    private Integer id;

    private Integer userId;

    private String content;

    private Date time;

    private Integer state;

    private Boolean isDeleted;

}
