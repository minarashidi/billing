package com.rashidi.billing.notifier.service.impl;

import com.rashidi.billing.notifier.dao.BillingDao;
import com.rashidi.billing.notifier.model.Billing;
import com.rashidi.billing.notifier.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

/**
 * An implementation for BillingService.
 *
 * @author Mina rashidi
 */
@Transactional
@Service
public class BillingServiceImpl implements BillingService {

    private BillingDao billingDao;

    public List<Billing> findByDueDate(Instant instant) {
        return billingDao.findByDueDate(instant);
    }

    public void update(Billing entity) {
        billingDao.update(entity);
    }

    @Autowired
    public void setBillingDao(BillingDao billingDao) {
        this.billingDao = billingDao;
    }
}
