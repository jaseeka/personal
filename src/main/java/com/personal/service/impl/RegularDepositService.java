package com.personal.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.common.Page;
import com.personal.dao.RegularDepositDao;
import com.personal.entity.Plan;
import com.personal.entity.RegularDeposit;
import com.personal.service.IRegularDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jaseeka
 * Date 2015/11/16
 * Time 8:42
 */
@Service
public class RegularDepositService implements IRegularDepositService {

    @Autowired
    private RegularDepositDao regularDepositDao;

    /**
     * 根据id获取
     * @param id
     * @return
     */
    @Override
    public RegularDeposit getById(Integer id){

        if (id == null || id <= 0){
            return null;
        }
        RegularDeposit reqRegularDeposit = new RegularDeposit();
        reqRegularDeposit.setId(id);

        return regularDepositDao.selectById(reqRegularDeposit);
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
        RegularDeposit reqRegularDeposit = new RegularDeposit();
        reqRegularDeposit.setId(id);

        return regularDepositDao.deleteById(reqRegularDeposit) > 0 ? true : false;
    }

    /**
     * 添加（返回id）
     * @param obj
     * @return
     */
    @Override
    public Integer insert(RegularDeposit obj){

        if (obj == null){
            return 0;
        }

        Integer result = regularDepositDao.insert(obj);

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
    public Integer count(RegularDeposit obj){
        if (obj == null){
            obj = new RegularDeposit();
        }
        return regularDepositDao.selectAndLikeCount(obj);
    }

    /**
     * 更新
     * @param obj
     * @return
     */
    @Override
    public Boolean update(RegularDeposit obj){
        if (obj == null || obj.getId() == null || obj.getId() <= 0){
            return false;
        }

        return regularDepositDao.update(obj) > 0 ? true : false;
    }

    /**
     * 获取列表
     * @param obj
     * @param page
     * @return
     */
    @Override
    public PageList<RegularDeposit> getList(RegularDeposit obj, Page page){
        if (obj == null){
            obj = new RegularDeposit();
        }
        if (page == null){
            page = new Page();
        }

        return regularDepositDao.selectAndLike(obj, page.gainPageBounds());
    }

    /**
     * 添加定存金额
     */
    @Override
    public boolean addCycleNum(){

        RegularDeposit reqRegularDeposit = new RegularDeposit();
        reqRegularDeposit.setIsDeleted(false);

        PageList<RegularDeposit> regularDepositList = getList(reqRegularDeposit, null);

        if (regularDepositList == null || regularDepositList.size() <= 0){
            return false;
        }

        for (RegularDeposit regularDeposit : regularDepositList) {
            regularDeposit.setNumber(regularDeposit.getNumber() + regularDeposit.getCycleNum());
            update(regularDeposit);
        }
        return true;
    }
}
