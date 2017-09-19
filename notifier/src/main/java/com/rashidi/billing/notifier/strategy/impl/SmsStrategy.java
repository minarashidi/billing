package com.rashidi.billing.notifier.strategy.impl;

import com.rashidi.billing.notifier.model.*;
import com.rashidi.billing.notifier.service.SmsNotificationService;
import com.rashidi.billing.notifier.service.impl.NotificationProcessorServiceImpl;
import com.rashidi.billing.notifier.strategy.NotificationStrategy;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Component
public class SmsStrategy implements NotificationStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationProcessorServiceImpl.class);

    private SmsNotificationService smsNotificationService;
    private Template template;
    private Configuration freeMarkerConfiguration;

    @Override
    public boolean match(NotificationType type) {
        return type == NotificationType.SMS;
    }

    @Override
    public void generate(Billing billing, Customer customer) throws Exception {

        Map<String, Object> model = new HashMap<>();
        model.put("billing", billing);
        model.put("customer", customer);

        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

        SmsNotification smsNotification = new SmsNotification();
        smsNotification.setContent(content);
        smsNotification.setMobile(customer.getMobile());
        smsNotification.setStatus(NotificationStatus.NEW);
        smsNotification.setCreatedDate(Instant.now());
        smsNotificationService.add(smsNotification);
    }

    @Autowired
    public void setSmsNotificationService(SmsNotificationService smsNotificationService) {
        this.smsNotificationService = smsNotificationService;
    }

    @PostConstruct
    public void init() throws IOException {
        template = freeMarkerConfiguration.getTemplate("sms.ftl");
    }

    @Autowired
    public void setFreeMarkerConfiguration(Configuration freeMarkerConfiguration) {
        this.freeMarkerConfiguration = freeMarkerConfiguration;
    }
}
