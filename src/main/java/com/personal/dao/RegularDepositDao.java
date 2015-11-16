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
    /**
     * 通用id查询操作
     * @param object
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectById")
    public RegularDeposit selectById(RegularDeposit object);

    /**
     * 通用多条件or查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectOr")
    public PageList<RegularDeposit> selectOr(RegularDeposit object, PageBounds page);

    /**
     * 通用多条件and查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectAnd")
    public PageList<RegularDeposit> selectAnd(RegularDeposit object, PageBounds page);

    /**
     * 通用like多条件or查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectOrLike")
    public PageList<RegularDeposit> selectOrLike(RegularDeposit object, PageBounds page);

    /**
     * 通用like多条件and查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectAndLike")
    public PageList<RegularDeposit> selectAndLike(RegularDeposit object, PageBounds page);
}
