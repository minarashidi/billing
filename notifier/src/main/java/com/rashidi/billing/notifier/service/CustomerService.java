package com.rashidi.billing.notifier.service;

import com.rashidi.billing.notifier.exception.NotFoundException;
import com.rashidi.billing.notifier.model.Customer;

/**
 * Services for using Customer.
 *
 * @author Mina Rashidi
 */
public interface CustomerService {

    Customer findById(long id) throws NotFoundException;
}
