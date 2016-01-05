package com.personal.dao;

import com.common.dao.BaseDao;
import com.common.dao.SQLTemplate;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.entity.Item;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Created by jaseeka
 * Date 2015/9/24
 * Time 22:18
 */
public interface ItemDao extends BaseDao<Item> {


}
