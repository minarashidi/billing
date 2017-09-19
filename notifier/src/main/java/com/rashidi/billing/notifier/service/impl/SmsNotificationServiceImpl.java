package com.rashidi.billing.notifier.service.impl;

import com.rashidi.billing.notifier.dao.SmsNotificationDao;
import com.rashidi.billing.notifier.model.SmsNotification;
import com.rashidi.billing.notifier.service.SmsNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * An implementation for SmsNotificationService.
 *
 * @author Mina Rashidi
 */
@Transactional
@Service
public class SmsNotificationServiceImpl implements SmsNotificationService {

    private SmsNotificationDao smsNotificationDao;

    @Override
    public long add(SmsNotification smsNotification) {
        return smsNotificationDao.add(smsNotification);
    }

    @Autowired
    public void setSmsNotificationDao(SmsNotificationDao smsNotificationDao) {
        this.smsNotificationDao = smsNotificationDao;
    }

}
