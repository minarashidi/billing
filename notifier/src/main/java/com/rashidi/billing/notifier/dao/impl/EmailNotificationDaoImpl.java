package com.rashidi.billing.notifier.dao.impl;

import com.rashidi.billing.notifier.dao.EmailNotificationDao;
import com.rashidi.billing.notifier.model.EmailNotification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Am implementation for EmailNotificationDao.
 *
 * @author Mina Rashidi
 */
@Repository
public class EmailNotificationDaoImpl implements EmailNotificationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long add(EmailNotification emailNotification) {
        entityManager.persist(emailNotification);
        return emailNotification.getId();
    }
}
