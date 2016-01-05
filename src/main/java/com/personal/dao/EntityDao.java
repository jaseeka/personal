package com.personal.dao;

import com.personal.entity.Entity;
import com.common.dao.BaseDao;
import com.common.dao.SQLTemplate;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Created by jaseeka
 * Date 2015/8/6
 * Time 15:54
 */
public interface EntityDao extends BaseDao<Entity> {


}
