package com.personal.dao;

import com.common.dao.BaseDao;
import com.common.dao.SQLTemplate;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.entity.Plan;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Created by jaseeka
 * Date 2015/10/27
 * Time 22:31
 */
public interface PlanDao extends BaseDao<Plan> {

}
