package com.rashidi.billing.emailsender.config;

import com.rashidi.billing.emailsender.job.EmailJob;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

@Configuration
public class QuartzConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public JobDetailFactoryBean jobDetail() {
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
        jobDetailFactory.setJobClass(EmailJob.class);
        jobDetailFactory.setDescription("Invoke Email Job...");
        jobDetailFactory.setDurability(true);
        return jobDetailFactory;
    }

    @Bean
    public CronTriggerFactoryBean trigger(JobDetail jobDetail) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(jobDetail);
        trigger.setStartDelay(3000);
        trigger.setCronExpression("0 0 23 ? * * *");
        return trigger;
    }

    @Bean
    public SchedulerFactoryBean scheduler(Trigger trigger, JobDetail jobDetail) {
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
        schedulerFactory.setConfigLocation(new ClassPathResource("email.properties"));
        schedulerFactory.setJobFactory(springBeanJobFactory());
        schedulerFactory.setJobDetails(jobDetail);
        schedulerFactory.setTriggers(trigger);
        return schedulerFactory;
    }

    @Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

}
