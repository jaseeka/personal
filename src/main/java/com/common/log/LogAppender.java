package com.common.log;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;

/**
 * 日志拦截过滤分级输出
 * Created by jaseeka
 * Date 2015/11/17
 * Time 14:32
 */
public class LogAppender extends DailyRollingFileAppender {

    @Override
    public boolean isAsSevereAsThreshold(Priority priority){
        return this.getThreshold().equals(priority);
    }
}
