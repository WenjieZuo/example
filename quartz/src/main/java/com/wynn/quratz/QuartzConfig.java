package com.wynn.quratz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.DirectSchedulerFactory;
import org.quartz.simpl.RAMJobStore;
import org.quartz.simpl.SimpleThreadPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    private final int threadCount = 10;
    private final int threadPriority = 5;

    @Bean
    public Scheduler scheduler() throws SchedulerException {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool(threadCount, threadPriority);
        simpleThreadPool.setThreadNamePrefix("job-thread");
        DirectSchedulerFactory factory = DirectSchedulerFactory.getInstance();
        factory.createScheduler(simpleThreadPool, new RAMJobStore());
        return factory.getScheduler();
    }

}
