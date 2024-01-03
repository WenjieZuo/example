package com.wynn.quratz;

import com.wynn.quratz.job.MyJob;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.ParseException;

@SpringBootApplication
public class QuartzApplication {


    public static void main(String[] args) throws ParseException, SchedulerException {
        ConfigurableApplicationContext run = SpringApplication.run(QuartzApplication.class, args);

        JobDetailImpl jobDetailImpl = new JobDetailImpl();
        jobDetailImpl.setName("name");
        jobDetailImpl.setGroup("group");
        jobDetailImpl.setJobClass(MyJob.class);
        //设置触发器
        CronTriggerImpl cronTrigger = new CronTriggerImpl();
        cronTrigger.setName("name");
        cronTrigger.setGroup("group");
        cronTrigger.setJobKey(jobDetailImpl.getKey());
        cronTrigger.setCronExpression("0/1 * * * * ?");

        Scheduler scheduler = run.getBean("scheduler", Scheduler.class);
        scheduler.scheduleJob(jobDetailImpl, cronTrigger);

        scheduler.start();
    }


}
