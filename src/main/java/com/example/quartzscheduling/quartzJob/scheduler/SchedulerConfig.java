package com.example.quartzscheduling.quartzJob.scheduler;

import com.example.quartzscheduling.quartzJob.AutowiringSpringBeanJobFactory;
import org.quartz.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * @author BAO 7/18/2023
 */
@Configuration
public class SchedulerConfig {
//  private final JobDetail jobDetail;
//  private final Trigger trigger;

  private final ApplicationContext applicationContext;

  public SchedulerConfig(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

//  public SchedulerConfig(
//          @Qualifier("jobDetail") JobDetail jobDetail, @Qualifier("jobTriggerBoot") Trigger trigger, ApplicationContext applicationContext) {
//    this.jobDetail = jobDetail;
//    this.trigger = trigger;
//    this.applicationContext = applicationContext;
//  }

  /**
   * Once the scheduler is instantiated, it needs to be started. Note triggers will not fire (and
   * therefore, jobs will not execute) ) until the scheduler has been started.
   *
   * <p>we have to initialize the scheduler instance from Quartz by using StdSchedulerFactory()
   * method.
   *
   * <p>After that, we start the scheduler instance with the Quartz API start() method.
   *
   * <p>Next, we create a scheduler trigger by using the SimpleScheduleBuilder from the Quartz
   * TriggerBuilder with an interval of 1 minute.
   *
   * <p>For the CreateQuartzJob, we build an instance of JobDetail from the Quartz JobBuilder.
   *
   * <p>In the last step, we schedule a job with the instance of the JobDetail and trigger created
   * before.
   */
  //  @Bean
  //  @DependsOn({"jobDetail", "jobTriggerBoot"})
  //  public void initialJob() {
  //    System.out.println("initial scheduler");
  //    SchedulerFactory schedulerFactory = new StdSchedulerFactory();
  //    try {
  //      Scheduler scheduler = schedulerFactory.getScheduler();
  //      scheduler.start();
  //
  //      jobDetail
  //      scheduler.scheduleJob(jobDetail, trigger);
  //
  //    } catch (SchedulerException e) {
  //      e.printStackTrace();
  //    }
  //  }

  @Bean
  public SchedulerFactoryBean scheduler(Trigger trigger, JobDetail jobDetail) {
    SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
    scheduler.setConfigLocation(new ClassPathResource("quartz.properties"));
    scheduler.setJobFactory(springBeanJobFactory());
    scheduler.setTriggers(trigger);
    return scheduler;
  }

  /**
   * SpringBeanJobFactory provides supper for injecting the scheduler context, job data map, and
   * trigger data entries as poperties into the bean while creating an instance
   */
  @Bean
  public SpringBeanJobFactory springBeanJobFactory() {
    AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
    jobFactory.setApplicationContext(applicationContext);
    return jobFactory;
  }
}
