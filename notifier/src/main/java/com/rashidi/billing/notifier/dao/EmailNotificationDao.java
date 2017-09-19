package com.rashidi.billing.notifier.dao;

import com.rashidi.billing.notifier.model.EmailNotification;

/**
 * A dao for EmailNotification.
 *
 * @author Mina Rashidi
 */
public interface EmailNotificationDao {

    long add(EmailNotification emailNotification);
}
