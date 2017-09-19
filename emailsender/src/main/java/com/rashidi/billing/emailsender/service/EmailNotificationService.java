package com.rashidi.billing.emailsender.service;

import com.rashidi.billing.emailsender.model.EmailNotification;

import java.util.List;

/**
 * Services for using EmailNotification.
 *
 * @author Mina Rashidi
 */
public interface EmailNotificationService {

    List<EmailNotification> find();

    void update(EmailNotification emailNotification);
}
