package com.personal.service.impl;

import com.common.service.BaseService;
import com.personal.common.TypeEnum;
import com.personal.entity.DateItem;
import com.personal.service.IDateItemService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/7/31.
 */
@Service
public class DateItemService extends BaseService<DateItem> implements IDateItemService {
    @Override
    public Boolean completeDateItem(Integer itemId) {
        DateItem item = new DateItem();
        item.setId(itemId);
        item.setState(TypeEnum.ItemState.DONE.ordinal());

        return update(item);
    }

    @Override
    public Boolean abandonDateItem(Integer itemId) {
        DateItem item = new DateItem();
        item.setId(itemId);
        item.setState(TypeEnum.ItemState.ABANDON.ordinal());

        return update(item);
    }
}
