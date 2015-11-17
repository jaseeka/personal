package com.common.dao;



import com.common.annotation.NoColumn;
import com.common.utils.ClassUtils;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 基础实体类，其他实体需继承
 * Created by jaseeka
 * date 2015/7/22
 * time 14:46
 */
public class BaseEntity implements Serializable {

    // 表明前缀
    private static final String TABLE_PREFIX = "tb";
    private static final String PRIMARY_KEY = "id";

    /**
     * 获取Entity对应的表名
     * 不需要Entity中的属性定义@Table(name)
     *
     * @return
     */
    public String gainTableName() {
        return ClassUtils.getClassName(this.getClass());
    }

    /**
     * 获取Entity对应的id名称
     *
     * @return
     */
    public String gainPrimaryKey() {
        return PRIMARY_KEY;
    }

    /**
     * 获取驼峰转成下划线属性名集合
     *
     * @return
     */
    public Map<String, String> gainAttributesToDatabaseMap() {

        Map<String, String> newAttrs = new HashMap<String, String>();

        for (String attrName : ClassUtils.getAttributesName(this.getClass()))
            newAttrs.put(attrName, changeAttrToDatabase(attrName));

        return newAttrs;
    }

    /**
     * 属性名转换成下划线写法
     *
     * @param attr
     * @return
     */
    public String changeAttrToDatabase(String attr) {

        StringBuffer newAttr = new StringBuffer();

        for (char c : attr.toCharArray())
            if (Character.isUpperCase(c))
                newAttr.append("_" + Character.toLowerCase(c));
            else
                newAttr.append(c);

        return newAttr.toString();
    }

    /**
     * 判断对象属性是否为空
     *
     * @param attrName
     * @return
     */
    public boolean isNull(String attrName) {
        Object value = ClassUtils.getAttributeValue(this, attrName);
        if (value == null)
            return true;
        else
            return false;
    }

    /**
     * 获取对象属性名集合
     *
     * @return
     */
    public Set<String> gainAttributesNameSet() {
        // 存储属性集合
        Set<String> set = new HashSet<String>();
        // 获取本类属性
        Field[] fields = this.getClass().getDeclaredFields();
        // 循环添加属性
        for (Field field : fields) {
            if (!isNoColumnAnnotation(field)) {
                String name = field.getName();
                set.add(name);
            }
        }
        return set;
//        return ClassUtils.getAttributesName(this.getClass());
    }

    /**
     * 查看属性是否有相应的注解
     * @param field
     * @return
     */
    public static Boolean isNoColumnAnnotation(Field field){

        Annotation annotation = field.getAnnotation(NoColumn.class);

        if (annotation == null){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 获取查询结果映射
     *
     * @return
     */
    public String gainAllAttributesMapperToDatabase() {
        // 获取属性名集合
        Set<String> attrSet = gainAttributesNameSet();
        Map<String, String> attrMap = gainAttributesToDatabaseMap();

        boolean isFirst = true;

        StringBuffer selectMapper = new StringBuffer();
        for (String attrName : attrSet)
            if (isFirst) {
                isFirst = false;
//                selectMapper.append(attrMap.get(attrName))
                selectMapper.append(attrName)
                        .append(" as ")
                        .append(attrName);
            } else {
                selectMapper.append(",")
//                        .append(attrMap.get(attrName))
                        .append(attrName)
                        .append(" as ")
                        .append(attrName);
            }

        return selectMapper.toString();
    }

}
