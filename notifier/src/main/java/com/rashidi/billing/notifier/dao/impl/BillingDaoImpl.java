package com.rashidi.billing.notifier.dao.impl;

import com.rashidi.billing.notifier.dao.BillingDao;
import com.rashidi.billing.notifier.model.Billing;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.Instant;
import java.util.List;

/**
 * An implementation for BillingDao.
 *
 * @author Mina Rashidi
 */

@Repository
public class BillingDaoImpl implements BillingDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Billing> findByDueDate(Instant instant) {
        Query query = entityManager.createQuery("from Billing where dueDate <= :instant and billingNotificationStatus='NEW'");
        query.setParameter("instant", instant);
        return query.getResultList();
    }

    public void update(Billing entity) {
        entityManager.merge(entity);
    }
}
