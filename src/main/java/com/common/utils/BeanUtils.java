package com.common.utils;

import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by jaseeka
 * Date 2016/1/5
 * Time 10:57
 */
public class BeanUtils {


    /**
     * map集合转换成Bean
     * @param map
     * @param clas
     * @param <T>
     * @return
     */
    public static <T> T changeToBean(Map<String, Object> map, Class clas) {
        if (map == null){
            return null;
        }
        // 获取key集合  实例对象  方法集合
        Set<String> keySet = map.keySet();
        T object = (T)ClassUtils.createInstance(clas);
        Method[] methods = object.getClass().getDeclaredMethods();
        // 循环执行set方法
        for (Method method : methods){
            if (method.getName().startsWith("set")){// 判断是否是set方法
                String attrName = ClassUtils.lowerCaseFirst(method.getName().substring(3)); // 获取属性名
                if (keySet.contains(attrName)){ // 判断属性是否在结果集中
                    Class attrType = ClassUtils.getAttributeType(object, attrName);
                    Object value = map.get(attrName);
                    // 特殊类型处理
                    if ((attrType.equals(boolean.class) || attrType.equals(Boolean.class)) && (value.equals(1) || value.equals(0))){
                        value = value.equals(1) ? true : false;
                    }

                    ClassUtils.setAttributeValue(object,attrName,value);
//                    try {
//                        method.invoke(object, new Object[]{value});
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    } catch (InvocationTargetException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        }

        return object;
    }

    /**
     * map集合转bean集合
     * @param maps
     * @param clas
     * @param <T>
     * @return
     */
    public static  <T>PageList<T> changeToBeanList(PageList<Map<String, Object>> maps, Class clas){

        if (maps == null || maps.size() <= 0){
            return null;
        }

        PageList<T> pageList = new PageList<T>(maps.getPaginator());

        for (Map<String, Object> map : maps){
            T object = changeToBean(map, clas);
            pageList.add(object);
        }

        return pageList;
    }

    /**
     * 对象转成Map集合
     * @param bean
     * @return
     */
    public static Map convertBean(Object bean){
        try{
            Class type = bean.getClass();
            Map returnMap = new HashMap();
            BeanInfo beanInfo = Introspector.getBeanInfo(type);

            PropertyDescriptor[] propertyDescriptors = beanInfo
                    .getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean, new Object[0]);
                    if (result != null) {
                        returnMap.put(propertyName, result);
                    } else {
                        returnMap.put(propertyName, "");
                    }
                }
            }
            return returnMap;
        }catch (Exception e){
            e.printStackTrace();
            return new HashMap();
        }

    }
}
