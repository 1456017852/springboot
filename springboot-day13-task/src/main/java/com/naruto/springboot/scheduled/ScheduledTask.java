package com.naruto.springboot.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTask {

    /**
     * second(秒)、minute(分)、hour(时)、day of mouth(一个月的那天)、mouth(月)、day of week(星期几)
     */
    @Scheduled(cron = "0 * * * * 0-7")
    //@Scheduled(cron = "0,1,2,3 * * * * 0-7")  //枚举 0,1,2,3 每秒执行一次
    //@Scheduled(cron = "0-10 * * * * 0-7")   //指定区间 0-10秒内每一秒执行一次
    //@Scheduled(cron = "0/5 * * * * 0-7")   //从0秒启动每5秒执行一次
    //0-7：代表从星期天到星期天(0,7 代表星期天; 1 代表星期一...6代表星期六)
    public void scheduledTask(){
        System.out.println("scheduledTask...");
    }


}
