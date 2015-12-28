package com.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by jaseeka
 * Date 2015/11/26
 * Time 15:43
 */
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    public static Object getBean(Class c){
        return getApplicationContext().getBean(c);
    }
}
