package com.personal.entity;

import com.common.dao.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * �ƻ�
 * Created by jaseeka
 * Date 2015/8/16
 * Time 21:49
 */
@Data
public class Plan extends BaseEntity {

    private Integer id;

    private Integer userId;

    private String content;

    private Integer cycleNum;

    private Date time;

}
