/*
package com.esurfing.tianmao.task;

import com.esurfing.tianmao.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class SheduleTaskService {

    private Logger log = LoggerFactory.getLogger(SheduleTaskService.class);

    @Autowired
    private OrderService orderService;

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void getOrder() {
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.MINUTE, -120);// 120分钟之前的时间 因为存在有人创建了订单，但没有及时付款
        Date before2Date = beforeTime.getTime();
        String startDate = Constants.DATA_FORMAT.sd1.format(before2Date);
        String endDate = Constants.DATA_FORMAT.sd1.format(new Date());
        log.info("定时任务执行,时间段:"+startDate+"~"+endDate);
        try {
            orderService.getOrder(startDate,endDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
