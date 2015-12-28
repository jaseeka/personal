package com.personal.service.impl;

import com.common.service.BaseService;
import com.personal.common.TypeEnum;
import com.personal.dao.ItemDao;
import com.personal.entity.Item;
import com.personal.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jaseeka
 * Date 2015/9/24
 * Time 21:43
 */
@Service
public class ItemService extends BaseService<Item> implements IItemService {

    @Autowired
    private ItemDao itemDao;

    /**
     * 获取总记录数
     * @param obj
     * @return
     */
    public Integer count(Item obj){
        if (obj == null){
            obj = new Item();
        }
        return itemDao.selectAndLikeCount(obj);
    }

    /**
     * 完成事项
     * @param itemId
     * @return
     */
    @Override
    public Boolean completeItem(Integer itemId){
        Item item = new Item();
        item.setId(itemId);
        item.setState(TypeEnum.ItemState.DONE.ordinal());

        return update(item);
    }

    /**
     * 放弃事项
     * @param itemId
     * @return
     */
    @Override
    public Boolean abandonItem(Integer itemId){
        Item item = new Item();
        item.setId(itemId);
        item.setState(TypeEnum.ItemState.ABANDON.ordinal());

        return update(item);
    }
}
