package com.rashidi.billing.notifier.service;

import com.rashidi.billing.notifier.model.SmsNotification;

/**
 * Services for using SmsNotification.
 *
 * @author Mina Rashidi
 */
public interface SmsNotificationService {

    long add(SmsNotification smsNotification);
}
