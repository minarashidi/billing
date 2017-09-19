package com.rashidi.billing.emailsender.service.impl;

import com.rashidi.billing.emailsender.dao.EmailNotificationDao;
import com.rashidi.billing.emailsender.model.EmailNotification;
import com.rashidi.billing.emailsender.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * An implementation for EmailNotificationService.
 *
 * @author Mina Rashidi
 */
@Transactional
@Service
public class EmailNotificationServiceImpl implements EmailNotificationService {

    private EmailNotificationDao emailNotificationDao;

    @Override
    public List<EmailNotification> find() {
        return emailNotificationDao.find();
    }

    @Override
    public void update(EmailNotification emailNotification) {
        emailNotificationDao.update(emailNotification);
    }

    @Autowired
    public void setEmailNotificationDao(EmailNotificationDao emailNotificationDao) {
        this.emailNotificationDao = emailNotificationDao;
    }

}
