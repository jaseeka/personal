package com.personal.entity;

import com.common.dao.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * Created by jaseeka
 * Date 2015/11/16
 * Time 8:36
 */
@Data
public class RegularDeposit extends BaseEntity{

    private Integer id;

    private Integer userId;

    private String content;

    private Integer number;

    private Integer cycleNum;

    private Boolean isDeleted;

    private Date time;

}
