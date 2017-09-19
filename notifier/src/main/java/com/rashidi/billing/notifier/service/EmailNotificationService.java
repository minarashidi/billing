package com.rashidi.billing.notifier.service;

import com.rashidi.billing.notifier.model.EmailNotification;

/**
 * Services for using EmailNotification.
 *
 * @author Mina Rashidi
 */
public interface EmailNotificationService {

    long add(EmailNotification emailNotification);
}
