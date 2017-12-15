package com.personal.entity;

import com.common.annotation.NoColumn;
import com.common.dao.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 事项
 * Created by jaseeka
 * Date 2015/8/16
 * Time 21:46
 */
@Data
public class Item extends BaseEntity{

    private Integer id;

    private Integer userId;

    private String content;

    private Date time;

    private Integer state;

    private Boolean isDeleted;
}
