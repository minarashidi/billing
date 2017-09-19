package com.rashidi.billing.notifier.service;

import com.rashidi.billing.notifier.model.Billing;

import java.time.Instant;
import java.util.List;

/**
 * Services for using Billing.
 *
 * @author Mina Rashidi
 */
public interface BillingService {

    List<Billing> findByDueDate(Instant instant);

    void update(Billing entity);
}
