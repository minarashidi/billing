package com.rashidi.billing.notifier.dao;

import com.rashidi.billing.notifier.model.Customer;

import java.util.Optional;

/**
 * A dao for Customer.
 *
 * @author Mina Rashidi
 */
public interface CustomerDao {

    Optional<Customer> findById(long id);
}
