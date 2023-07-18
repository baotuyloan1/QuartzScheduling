package com.example.quartzscheduling.quartzJob.detail;

import com.example.quartzscheduling.quartzJob.job.BootJob;
import com.example.quartzscheduling.quartzJob.service.UserService;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

/**
 * @author BAO 7/18/2023
 */
@Configuration
public class JobDetailConfig {

  private UserService userService;
  @Bean(name = "jobDetail")
  public JobDetailFactoryBean jobDetail() {
    JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
    jobDetailFactoryBean.setJobClass(BootJob.class);
    jobDetailFactoryBean.setDescription("Description");
    jobDetailFactoryBean.setDurability(true);
    return jobDetailFactoryBean;
  }
}
