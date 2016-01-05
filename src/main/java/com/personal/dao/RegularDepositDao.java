package com.personal.dao;

import com.common.dao.BaseDao;
import com.common.dao.SQLTemplate;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.entity.Plan;
import com.personal.entity.RegularDeposit;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Created by jaseeka
 * Date 2015/11/16
 * Time 8:40
 */
public interface RegularDepositDao extends BaseDao<RegularDeposit> {

}
