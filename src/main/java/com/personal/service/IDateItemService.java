package com.personal.service;

import com.common.service.IBaseService;

/**
 * Created by Administrator on 2016/7/31.
 */
public interface IDateItemService extends IBaseService {

    /**
     * 完成任务
     * @param itemId
     * @return
     */
    public Boolean completeDateItem(Integer itemId);

    /**
     * 放弃任务
     * @param itemId
     * @return
     */
    public Boolean abandonDateItem(Integer itemId);
}
