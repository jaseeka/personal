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

    /**
     * 通用id查询操作
     * @param object
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectById")
    public Entity selectById(Entity object);

    /**
     * 通用多条件or查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectOr")
    public PageList<Entity> selectOr(Entity object, PageBounds page);

    /**
     * 通用多条件and查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectAnd")
    public PageList<Entity> selectAnd(Entity object, PageBounds page);

    /**
     * 通用like多条件or查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectOrLike")
    public PageList<Entity> selectOrLike(Entity object, PageBounds page);

    /**
     * 通用like多条件and查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectAndLike")
    public PageList<Entity> selectAndLike(Entity object, PageBounds page);
}
