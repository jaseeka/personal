package com.common.service;

import com.common.ParamConstants;
import com.common.common.Page;
import com.common.dao.BaseDao;
import com.common.dao.BaseEntity;
import com.common.utils.BeanUtils;
import com.common.utils.ClassUtils;
import com.common.utils.SpringUtils;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;


/**
 * Created by jaseeka
 * Date 2015/11/26
 * Time 15:41
 */
@Component
public class BaseService<E> {

    @Resource
    private ParamConstants paramConstants;

    /**
     * 类名
     */
    private String serviceClassName = ClassUtils.getClassName(this.getClass());

    /**
     * 根据id获取对象
     * @param id
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> E getById(Integer id){

        if (id == null || id <= 0){
            return null;
        }
        String entityName = replaceServicePrefix(serviceClassName, paramConstants.SERVICE_PREFIX);
        String daoName = ClassUtils.lowerCaseFirst(entityName) + "Dao";
        BaseDao<E> dao = (BaseDao<E>) SpringUtils.getBean(daoName);

        // 通过反射创建实体
        E entity = (E) ClassUtils.createInstance(paramConstants.ENTITY_PACKAGE + "." + entityName);
        // 设置id
        ClassUtils.setAttributeValue(entity, ParamConstants.PRIMARY_KEY.toString(), id);

        return BeanUtils.changeToBean(dao.selectById(entity),entity.getClass());
    }

    /**
     * 根据id获取对象
     * @param id
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> Map<String, Object> getByIdMap(Integer id){

        if (id == null || id <= 0){
            return null;
        }
        String entityName = replaceServicePrefix(serviceClassName, paramConstants.SERVICE_PREFIX);
        String daoName = ClassUtils.lowerCaseFirst(entityName) + "Dao";
        BaseDao<E> dao = (BaseDao<E>) SpringUtils.getBean(daoName);

        // 通过反射创建实体
        E entity = (E) ClassUtils.createInstance(paramConstants.ENTITY_PACKAGE + "." + entityName);
        // 设置id
        ClassUtils.setAttributeValue(entity, ParamConstants.PRIMARY_KEY.toString(), id);

        return dao.selectById(entity);
    }

    /**
     * 根据id删除对象
     * @param id
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> Boolean deleteById(Integer id){
        if (id == null || id <= 0){
            return null;
        }
        String entityName = replaceServicePrefix(serviceClassName, paramConstants.SERVICE_PREFIX);
        String daoName = ClassUtils.lowerCaseFirst(entityName) + "Dao";
        BaseDao<E> dao = (BaseDao<E>) SpringUtils.getBean(daoName);

        // 通过反射创建实体
        E entity = (E) ClassUtils.createInstance(paramConstants.ENTITY_PACKAGE + "." + entityName);
        // 设置id
        ClassUtils.setAttributeValue(entity, ParamConstants.PRIMARY_KEY.toString(), id);

        return dao.deleteById(entity) > 0 ? true :  false;
    }

    /**
     * 根据id删除对象
     * @param e
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> Boolean deleteAnd(E e){

        if (e == null){
            return false;
        }

        String entityName = replaceServicePrefix(serviceClassName, paramConstants.SERVICE_PREFIX);
        String daoName = ClassUtils.lowerCaseFirst(entityName) + "Dao";
        BaseDao<E> dao = (BaseDao<E>) SpringUtils.getBean(daoName);

        return dao.deleteAnd(e) > 0 ? true :  false;
    }

    /**
     * 插入对象 返回id
     * @param e
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> Integer add(E e){
        if (e == null){
            return 0;
        }
        String entityName = replaceServicePrefix(serviceClassName, paramConstants.SERVICE_PREFIX);
        String daoName = ClassUtils.lowerCaseFirst(entityName) + "Dao";
        BaseDao<E> dao = (BaseDao<E>) SpringUtils.getBean(daoName);

        dao.insert(e);

        return (Integer) ClassUtils.getAttributeValue(e, ParamConstants.PRIMARY_KEY.toString());
    }

    /**
     * 更新对象
     * @param e
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> Boolean update(E e){
        if (e == null || (Integer) ClassUtils.getAttributeValue(e, ParamConstants.PRIMARY_KEY.toString()) == null || (Integer) ClassUtils.getAttributeValue(e, ParamConstants.PRIMARY_KEY.toString()) <= 0){
            return false;
        }
        String entityName = replaceServicePrefix(serviceClassName, paramConstants.SERVICE_PREFIX);
        String daoName = ClassUtils.lowerCaseFirst(entityName) + "Dao";
        BaseDao<E> dao = (BaseDao<E>) SpringUtils.getBean(daoName);

        return dao.update(e) > 0 ? true :  false;
    }

    /**
     * 查询 And
     * @param e
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> PageList<E> getListAnd(E e, Page page){

        String entityName = replaceServicePrefix(serviceClassName, paramConstants.SERVICE_PREFIX);
        String daoName = ClassUtils.lowerCaseFirst(entityName) + "Dao";
        BaseDao<E> dao = (BaseDao<E>) SpringUtils.getBean(daoName);

        if (e == null ){
            e = (E) ClassUtils.createInstance(paramConstants.ENTITY_PACKAGE + "." + entityName);
        }
        if (page == null){
            page = new Page();
        }

        return BeanUtils.changeToBeanList(dao.selectAnd(e, page.gainPageBounds()), e.getClass());
    }

    /**
     * 查询 And
     * @param e
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> PageList<Map<String, Object>> getListAndMap(E e, Page page){

        String entityName = replaceServicePrefix(serviceClassName, paramConstants.SERVICE_PREFIX);
        String daoName = ClassUtils.lowerCaseFirst(entityName) + "Dao";
        BaseDao<E> dao = (BaseDao<E>) SpringUtils.getBean(daoName);

        if (e == null ){
            e = (E) ClassUtils.createInstance(paramConstants.ENTITY_PACKAGE + "." + entityName);
        }
        if (page == null){
            page = new Page();
        }

        return dao.selectAnd(e, page.gainPageBounds());
    }

    /**
     * 模糊查询 And
     * @param e
     * @param page
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> PageList<E> getListAndLike(E e, Page page){

        String entityName = replaceServicePrefix(serviceClassName, paramConstants.SERVICE_PREFIX);
        String daoName = ClassUtils.lowerCaseFirst(entityName) + "Dao";
        BaseDao<E> dao = (BaseDao<E>) SpringUtils.getBean(daoName);

        if (e == null ){
            e = (E) ClassUtils.createInstance(paramConstants.ENTITY_PACKAGE + "." + entityName);
        }
        if (page == null){
            page = new Page();
        }

        return BeanUtils.changeToBeanList(dao.selectAndLike(e, page.gainPageBounds()), e.getClass());
    }

    /**
     * 模糊查询 And
     * @param e
     * @param page
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> PageList<Map<String, Object>> getListAndLikeMap(E e, Page page){

        String entityName = replaceServicePrefix(serviceClassName, paramConstants.SERVICE_PREFIX);
        String daoName = ClassUtils.lowerCaseFirst(entityName) + "Dao";
        BaseDao<E> dao = (BaseDao<E>) SpringUtils.getBean(daoName);

        if (e == null ){
            e = (E) ClassUtils.createInstance(paramConstants.ENTITY_PACKAGE + "." + entityName);
        }
        if (page == null){
            page = new Page();
        }

        return dao.selectAndLike(e, page.gainPageBounds());
    }

    /**
     * 查询 Or
     * @param e
     * @param page
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> PageList<E> getListOr(E e, Page page){

        String entityName = replaceServicePrefix(serviceClassName, paramConstants.SERVICE_PREFIX);
        String daoName = ClassUtils.lowerCaseFirst(entityName) + "Dao";
        BaseDao<E> dao = (BaseDao<E>) SpringUtils.getBean(daoName);

        if (e == null ){
            e = (E) ClassUtils.createInstance(paramConstants.ENTITY_PACKAGE + "." + entityName);
        }
        if (page == null){
            page = new Page();
        }

        return BeanUtils.changeToBeanList(dao.selectOr(e, page.gainPageBounds()), e.getClass());
    }

    /**
     * 查询 Or
     * @param e
     * @param page
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> PageList<Map<String, Object>> getListOrMap(E e, Page page){

        String entityName = replaceServicePrefix(serviceClassName, paramConstants.SERVICE_PREFIX);
        String daoName = ClassUtils.lowerCaseFirst(entityName) + "Dao";
        BaseDao<E> dao = (BaseDao<E>) SpringUtils.getBean(daoName);

        if (e == null ){
            e = (E) ClassUtils.createInstance(paramConstants.ENTITY_PACKAGE + "." + entityName);
        }
        if (page == null){
            page = new Page();
        }

        return dao.selectOr(e, page.gainPageBounds());
    }

    /**
     * 模糊查询 Or
     * @param e
     * @param page
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> PageList<E> getListOrLike(E e, Page page){

        String entityName = replaceServicePrefix(serviceClassName, paramConstants.SERVICE_PREFIX);
        String daoName = ClassUtils.lowerCaseFirst(entityName) + "Dao";
        BaseDao<E> dao = (BaseDao<E>) SpringUtils.getBean(daoName);

        if (e == null ){
            e = (E) ClassUtils.createInstance(paramConstants.ENTITY_PACKAGE + "." + entityName);
        }
        if (page == null){
            page = new Page();
        }

        return BeanUtils.changeToBeanList(dao.selectOrLike(e, page.gainPageBounds()), e.getClass());
    }

    /**
     * 模糊查询 Or
     * @param e
     * @param page
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> PageList<Map<String, Object>> getListOrLikeMap(E e, Page page){

        String entityName = replaceServicePrefix(serviceClassName, paramConstants.SERVICE_PREFIX);
        String daoName = ClassUtils.lowerCaseFirst(entityName) + "Dao";
        BaseDao<E> dao = (BaseDao<E>) SpringUtils.getBean(daoName);

        if (e == null ){
            e = (E) ClassUtils.createInstance(paramConstants.ENTITY_PACKAGE + "." + entityName);
        }
        if (page == null){
            page = new Page();
        }

        return dao.selectOrLike(e, page.gainPageBounds());
    }

    /**
     * 去除service后缀
     * @param serviceName
     * @param prefix
     * @return
     */
    private static String replaceServicePrefix(String serviceName, String prefix){

        Integer lastIndex = serviceName.lastIndexOf(prefix);

        String name = serviceName.substring(0, lastIndex);

        return name;
    }

}
