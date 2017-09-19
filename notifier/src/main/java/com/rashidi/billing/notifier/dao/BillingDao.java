package com.rashidi.billing.notifier.dao;

import com.rashidi.billing.notifier.model.Billing;

import java.time.Instant;
import java.util.List;

/**
 * A dao for Billing.
 *
 * @author Mina Rashidi
 */
public interface BillingDao {

    List<Billing> findByDueDate(Instant instant);

    void update(Billing entity);
}
