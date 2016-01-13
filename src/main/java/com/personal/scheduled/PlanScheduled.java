package com.personal.scheduled;

import com.personal.service.IPlanService;
import com.personal.service.IRegularDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by jaseeka
 * Date 2015/11/8
 * Time 23:18
 */
@Component
public class PlanScheduled implements BaseScheduled {

    @Autowired
    private IPlanService planService;
    @Autowired
    private IRegularDepositService regularDepositService;

    /**
     * schedule 调用接口方法
     */
    @Override
    @Scheduled(cron = "0 0 1 ? * *") // 每天0点执行
    public void invoke() {
        planService.addCyclePlan();
        regularDepositService.addCycleMoney();
        System.out.println( new Date() + "   addCyclePlan");
    }
}
