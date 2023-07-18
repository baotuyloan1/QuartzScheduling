package com.example.quartzscheduling.quartzJob.trigger;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * @author BAO 7/18/2023
 */
@Configuration
public class JobTriggerConfig {

  @Bean(name = "jobTriggerBoot")
  public SimpleTriggerFactoryBean jobTriggerBoot(@Qualifier("jobDetail") JobDetail jobDetail) {

    System.out.println("Initial execute triggerRunBoot");
    SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
    trigger.setJobDetail(jobDetail);
    trigger.setRepeatInterval(1000);
    trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
    return trigger;
  }
}
