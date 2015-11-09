package com.personal.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by jaseeka
 * Date 2015/11/8
 * Time 23:18
 */
@Component
public class PlanScheduled implements BaseScheduled {

    /**
     * schedule 调用接口方法
     */
    @Override
    @Scheduled(cron = "0 0 0 ? * *") // 每天0点执行
    public void invoke() {

    }
}
