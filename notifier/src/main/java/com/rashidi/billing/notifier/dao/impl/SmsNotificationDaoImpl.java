package com.rashidi.billing.notifier.dao.impl;

import com.rashidi.billing.notifier.dao.SmsNotificationDao;
import com.rashidi.billing.notifier.model.SmsNotification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * An implementation for SmsNotificationDao.
 *
 * @author Mina Rashidi
 */
@Repository
public class SmsNotificationDaoImpl implements SmsNotificationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long add(SmsNotification smsNotification) {
        entityManager.persist(smsNotification);
        return smsNotification.getId();
    }
}
