package com.rashidi.billing.notifier.job;

import com.rashidi.billing.notifier.service.impl.NotificationProcessorServiceImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationJob.class);

    private NotificationProcessorServiceImpl notificationProcessorService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        notificationProcessorService.process();
    }

    @Autowired
    public void setNotificationProcessorService(NotificationProcessorServiceImpl notificationProcessorService) {
        this.notificationProcessorService = notificationProcessorService;
    }
}
