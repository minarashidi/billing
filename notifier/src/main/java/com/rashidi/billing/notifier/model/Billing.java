package com.rashidi.billing.notifier.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * An entity for representing a Billing.
 *
 * @author Mina Rashidi
 */
@Entity
@Table(name = "BILLING")
@SequenceGenerator(name = "S_BILLING", sequenceName = "S_BILLING", allocationSize = 1)
public class Billing {

    private long id;
    private BigDecimal amount;
    private long customerId;
    private Instant dueDate;
    private BillingNotificationStatus billingNotificationStatus;
    private Instant createdDate;
    private Instant changedDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_BILLING")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "AMOUNT")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name = "CUSTOMER_ID")
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Column(name = "DUE_DATE")
    public Instant getDueDate() {
        return dueDate;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    @Column(name = "BILLING_NOTIFICATION_STATUS")
    @Enumerated(EnumType.STRING)
    public BillingNotificationStatus getBillingNotificationStatus() {
        return billingNotificationStatus;
    }

    public void setBillingNotificationStatus(BillingNotificationStatus billingNotificationStatus) {
        this.billingNotificationStatus = billingNotificationStatus;
    }

    @Column(name = "CREATED_DATE")
    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "CHANGED_DATE")
    public Instant getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(Instant changedDate) {
        this.changedDate = changedDate;
    }
}
