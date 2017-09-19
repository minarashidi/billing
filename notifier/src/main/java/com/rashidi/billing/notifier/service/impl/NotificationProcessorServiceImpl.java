package com.rashidi.billing.notifier.service.impl;

import com.rashidi.billing.notifier.model.Billing;
import com.rashidi.billing.notifier.model.BillingNotificationStatus;
import com.rashidi.billing.notifier.model.Customer;
import com.rashidi.billing.notifier.model.NotificationType;
import com.rashidi.billing.notifier.service.BillingService;
import com.rashidi.billing.notifier.service.CustomerService;
import com.rashidi.billing.notifier.service.NotificationProcessorService;
import com.rashidi.billing.notifier.strategy.NotificationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * NotificationJob calls process() method and the process related to the Job puts here.
 * also we use strategy design pattern for Email and Sms notification
 *
 * @author Mina Rashidi
 */
@Service
public class NotificationProcessorServiceImpl implements NotificationProcessorService {

    private CustomerService customerService;
    private BillingService billingService;
    private NotificationContext notificationContext;

    public void process() {

        Instant tomorrow = Instant.now().plus(1, ChronoUnit.DAYS);
        List<Billing> billings = billingService.findByDueDate(tomorrow);

        for (Billing billing : billings) {

            try {
                Customer customer = customerService.findById(billing.getCustomerId());
                for (NotificationType type : NotificationType.values()) {
                    notificationContext.generate(type, billing, customer);
                }

                billing.setBillingNotificationStatus(BillingNotificationStatus.GENERATED);
                billing.setChangedDate(Instant.now());
                billingService.update(billing);

            } catch (Exception e) {
                billing.setBillingNotificationStatus(BillingNotificationStatus.FAILED);
                billing.setChangedDate(Instant.now());
                billingService.update(billing);
            }
        }
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setBillingService(BillingService billingService) {
        this.billingService = billingService;
    }

    @Autowired
    public void setNotificationContext(NotificationContext notificationContext) {
        this.notificationContext = notificationContext;
    }
}
