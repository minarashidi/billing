package com.rashidi.billing.notifier.dao;

import com.rashidi.billing.notifier.model.SmsNotification;

/**
 * A dao for SmsNotification.
 *
 * @author Mina Rashidi
 */
public interface SmsNotificationDao {

    long add(SmsNotification smsNotification);
}
