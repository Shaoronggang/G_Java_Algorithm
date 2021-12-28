package com.hzwq.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

// 定时任务的实现
public class ScheduledThreadPoolService {
    private Logger logger = Logger.getLogger(getClass().getSimpleName());
    private ScheduledExecutorService service = Executors.newScheduledThreadPool(3);//类似线程池的使用


    // 延迟2秒执行一次任务
    public void task0() {
        service.schedule(() -> {
            logger.info("task0-start");
            sleep(2);
            logger.info("task0-end");
        }, 2, TimeUnit.SECONDS);
    }

    public void task1() {
        service.scheduleAtFixedRate(() -> {
            logger.info("task1-start");
            sleep(2);
            logger.info("task1-end");
        }, 2, 4, TimeUnit.SECONDS);
    }

    public void task2() {
        service.scheduleAtFixedRate(() -> {
            logger.info("task2-start");
            sleep(2);
            logger.info("task2-end");
        }, 2, 4, TimeUnit.SECONDS);
    }


    private void sleep(long time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
