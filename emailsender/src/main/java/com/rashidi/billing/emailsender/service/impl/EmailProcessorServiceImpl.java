package com.rashidi.billing.emailsender.service.impl;

import com.rashidi.billing.emailsender.model.EmailNotification;
import com.rashidi.billing.emailsender.model.NotificationStatus;
import com.rashidi.billing.emailsender.service.EmailNotificationService;
import com.rashidi.billing.emailsender.service.EmailProcessorService;
import com.rashidi.billing.emailsender.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

/**
 *
 *
 *
 */
@Service
public class EmailProcessorServiceImpl implements EmailProcessorService {

    private EmailNotificationService emailNotificationService;
    private EmailService emailService;

    public void process() {

        List<EmailNotification> emailNotifications = emailNotificationService.find();
        for (EmailNotification emailNotification : emailNotifications) {
            try {
                emailService.send(emailNotification);
                emailNotification.setStatus(NotificationStatus.SENT);
                emailNotification.setChangedDate(Instant.now());
                emailNotificationService.update(emailNotification);
            } catch (Exception e) {
                emailNotification.setStatus(NotificationStatus.FAILED);
                emailNotification.setChangedDate(Instant.now());
                emailNotificationService.update(emailNotification);
            }
        }
    }

    @Autowired
    public void setEmailNotificationService(EmailNotificationService emailNotificationService) {
        this.emailNotificationService = emailNotificationService;
    }

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
}
