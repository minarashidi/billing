package com.rashidi.billing.notifier.dao.impl;

import com.rashidi.billing.notifier.dao.CustomerDao;
import com.rashidi.billing.notifier.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * An implementation for CustomerDao.
 *
 * @author Mina Rashidi
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Customer> findById(long id) {
        return Optional.ofNullable(entityManager.find(Customer.class, id));
    }
}
