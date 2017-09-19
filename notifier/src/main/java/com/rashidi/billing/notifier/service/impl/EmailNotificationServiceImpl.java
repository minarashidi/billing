package com.rashidi.billing.notifier.service.impl;

import com.rashidi.billing.notifier.dao.EmailNotificationDao;
import com.rashidi.billing.notifier.model.EmailNotification;
import com.rashidi.billing.notifier.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public long add(EmailNotification emailNotification) {
        return emailNotificationDao.add(emailNotification);
    }

    @Autowired
    public void setEmailNotificationDao(EmailNotificationDao emailNotificationDao) {
        this.emailNotificationDao = emailNotificationDao;
    }

}
