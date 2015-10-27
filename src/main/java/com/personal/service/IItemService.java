package com.personal.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.common.Page;
import com.personal.entity.Item;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by jaseeka
 * Date 2015/9/24
 * Time 21:43
 */
public interface IItemService {

    /**
     * 根据id获取
     * @param id
     * @return
     */
    public Item getById(Integer id);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public Boolean deleteById(Integer id);

    /**
     * 添加（返回id）
     * @param obj
     * @return
     */
    public Integer insert(Item obj);

    /**
     * 更新
     * @param obj
     * @return
     */
    public Boolean update(Item obj);

    /**
     * 获取总记录数
     * @param obj
     * @return
     */
    public Integer count(Item obj);

    /**
     * 获取列表
     * @param obj
     * @param page
     * @return
     */
    public PageList<Item> getList(Item obj, Page page);

    /**
     * 完成事项
     * @param itemId
     * @return
     */
    public Boolean completeItem(Integer itemId);

    /**
     * 放弃事项
     * @param itemId
     * @return
     */
    public Boolean abandonItem(Integer itemId);
}
