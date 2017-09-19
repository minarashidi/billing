package com.rashidi.billing.notifier.service.impl;

import com.rashidi.billing.notifier.dao.CustomerDao;
import com.rashidi.billing.notifier.exception.NotFoundException;
import com.rashidi.billing.notifier.model.Customer;
import com.rashidi.billing.notifier.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * An implementation for CustomerService.
 *
 * @author Mina Rashidi
 */
@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    public Customer findById(long id) throws NotFoundException {
        return customerDao.findById(id).orElseThrow(() ->
                new NotFoundException("Customer with id " + id + " not found."));
    }


    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
