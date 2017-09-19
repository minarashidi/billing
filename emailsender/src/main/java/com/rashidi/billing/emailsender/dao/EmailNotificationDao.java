package com.rashidi.billing.emailsender.dao;

import com.rashidi.billing.emailsender.model.EmailNotification;

import java.util.List;

/**
 * A dao for EmailNotification.
 *
 * @author Mina Rashidi
 */
public interface EmailNotificationDao {

    List<EmailNotification> find();
    void update(EmailNotification emailNotification);
}
