package com.example.quartzscheduling;

import org.quartz.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class QuartzSchedulingApplication {

  public static void main(String[] args) {
    SpringApplication.run(QuartzSchedulingApplication.class, args);
  }
}
