package com.personal.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.common.Page;
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
public class ItemService implements IItemService {

    @Autowired
    private ItemDao itemDao;

    /**
     * 根据id获取
     * @param id
     * @return
     */
    @Override
    public Item getById(Integer id){

        if (id == null || id <= 0){
            return null;
        }
        Item reqItem = new Item();
        reqItem.setId(id);

        return itemDao.selectById(reqItem);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Override
    public Boolean deleteById(Integer id){
        if (id == null || id <= 0){
            return false;
        }
        Item reqItem = new Item();
        reqItem.setId(id);

        return itemDao.deleteById(reqItem) > 0 ? true : false;
    }

    /**
     * 添加（返回id）
     * @param obj
     * @return
     */
    @Override
    public Integer insert(Item obj){

        if (obj == null){
            return 0;
        }

        Integer result = itemDao.insert(obj);

        if (result > 0){
            return obj.getId();
        }else {
            return 0;
        }
    }

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
     * 更新
     * @param obj
     * @return
     */
    @Override
    public Boolean update(Item obj){
        if (obj == null || obj.getId() == null || obj.getId() <= 0){
            return false;
        }

        return itemDao.update(obj) > 0 ? true : false;
    }

    /**
     * 获取列表
     * @param obj
     * @param page
     * @return
     */
    @Override
    public PageList<Item> getList(Item obj, Page page){
        if (obj == null){
            obj = new Item();
        }
        if (page == null){
            page = new Page();
        }

        return itemDao.selectAndLike(obj, page.gainPageBounds());
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
