package com.rashidi.billing.emailsender.job;

import com.rashidi.billing.emailsender.service.impl.EmailProcessorServiceImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailJob.class);

    private EmailProcessorServiceImpl emailProcessorService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        emailProcessorService.process();
    }

    @Autowired
    public void setEmailProcessorService(EmailProcessorServiceImpl emailProcessorService) {
        this.emailProcessorService = emailProcessorService;
    }
}
