package com.rashidi.billing.emailsender.dao.impl;

import com.rashidi.billing.emailsender.dao.EmailNotificationDao;
import com.rashidi.billing.emailsender.model.EmailNotification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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
    public List<EmailNotification> find() {
        Query query = entityManager.createQuery("from EmailNotification e where e.status='NEW'");
        return query.getResultList();
    }

    @Override
    public void update(EmailNotification emailNotification) {
        entityManager.merge(emailNotification);
    }
}
