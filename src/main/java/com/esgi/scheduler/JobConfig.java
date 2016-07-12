package com.esgi.scheduler;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    public SimpleTrigger moduleJobTriggerBean(@Qualifier("moduleJobTriggerFactoryBean") SimpleTriggerFactoryBean moduleJobTriggerFactoryBean) {
        return moduleJobTriggerFactoryBean.getObject();
    }

    @Bean(name = "moduleJobTriggerFactoryBean")
    public SimpleTriggerFactoryBean moduleJobTriggerFactoryBean() {
        SimpleTriggerFactoryBean stFactory = new SimpleTriggerFactoryBean();
        stFactory.setStartDelay(3000);
        stFactory.setRepeatInterval(TimeUnit.MILLISECONDS.convert(2000000000, TimeUnit.SECONDS));
        stFactory.setJobDetail(moduleJob());
        stFactory.isSingleton();
        stFactory.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        return stFactory;
    }
}
