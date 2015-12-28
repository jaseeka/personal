package com.common.service;

import com.common.common.Page;
import com.common.dao.BaseEntity;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * Created by jaseeka
 * Date 2015/12/2
 * Time 17:09
 */
public interface IBaseService {

    /**
     * 根据id获取对象
     * @param id
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> E getById(Integer id);
    /**
     * 根据id删除对象
     * @param id
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> Boolean deleteById(Integer id);

    /**
     * 根据id删除对象
     * @param e
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> Boolean deleteAnd(E e);

    /**
     * 插入对象 返回id
     * @param e
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> Integer add(E e);

    /**
     * 更新对象
     * @param e
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> Boolean update(E e);

    /**
     * 查询 And
     * @param e
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> PageList<E> getListAnd(E e, Page page);

    /**
     * 模糊查询 And
     * @param e
     * @param page
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> PageList<E> getListAndLike(E e, Page page);
    /**
     * 查询 Or
     * @param e
     * @param page
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> PageList<E> getListOr(E e, Page page);
    /**
     * 模糊查询 Or
     * @param e
     * @param page
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> PageList<E> getListOrLike(E e, Page page);

}
