package com.esgi.scheduler;

import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.util.concurrent.TimeUnit;

/**
 * Created by alex on 11/07/2016.
 */
@Configuration
public class JobConfig {
    @Bean
    public JobDetail moduleJob() {
        return JobBuilder.newJob(MyTask.class)
                .build();
    }

    @Bean
    public CronTrigger moduleJobTriggerBean(@Qualifier("moduleJobTriggerFactoryBean") CronTriggerFactoryBean moduleJobTriggerFactoryBean) {
        return moduleJobTriggerFactoryBean.getObject();
    }

    @Bean(name = "moduleJobTriggerFactoryBean")
    public CronTriggerFactoryBean moduleJobTriggerFactoryBean() {
        CronTriggerFactoryBean ctFactory = new CronTriggerFactoryBean();
        ctFactory.setJobDetail(moduleJob());
        ctFactory.isSingleton();
        //tous les jeudi a 23h30
        ctFactory.setCronExpression("0 30 23 ? * 5");


        return ctFactory;

    }
}
