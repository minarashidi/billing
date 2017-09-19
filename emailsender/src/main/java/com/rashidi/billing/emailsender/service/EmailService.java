package com.rashidi.billing.emailsender.service;

import com.rashidi.billing.emailsender.model.EmailNotification;

public interface EmailService {

    void send(EmailNotification emailNotification);
}
