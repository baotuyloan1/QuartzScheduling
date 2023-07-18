package com.example.quartzscheduling.quartzJob.job;

import com.example.quartzscheduling.quartzJob.service.UserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author BAO 7/18/2023
 */
@Component
public class BootJob implements Job {
  @Autowired private UserService userService;

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    System.out.println("run job");
    userService.handleUser();
  }
}
