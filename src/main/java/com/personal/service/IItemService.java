package com.personal.service;

import com.common.service.IBaseService;
import com.personal.entity.Item;

/**
 * Created by jaseeka
 * Date 2015/9/24
 * Time 21:43
 */
public interface IItemService extends IBaseService {

    /**
     * 获取总记录数
     * @param obj
     * @return
     */
    public Integer count(Item obj);

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
