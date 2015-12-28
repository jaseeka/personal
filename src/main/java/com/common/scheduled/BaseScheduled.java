package com.common.scheduled;

/**
 * 需添加配置
 * 定时任务扫描
 <task:annotation-driven />
 <bean id="applicationContext" class="com.common.utils.SpringUtils" />

 * Created by jaseeka
 * Date 2015/11/8
 * Time 22:38
 */
public interface BaseScheduled {

    /**
     * schedule 调用接口方法
     */
//    @Scheduled(cron = "0 0 1 ? * *") // 秒 分 时 日 月 年
    void invoke();
}
