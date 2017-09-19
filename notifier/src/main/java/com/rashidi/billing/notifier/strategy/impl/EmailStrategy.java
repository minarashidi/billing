package com.rashidi.billing.notifier.strategy.impl;

import com.rashidi.billing.notifier.model.*;
import com.rashidi.billing.notifier.service.EmailNotificationService;
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
public class EmailStrategy implements NotificationStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationProcessorServiceImpl.class);

    private EmailNotificationService emailNotificationService;
    private Template template;
    private Configuration freeMarkerConfiguration;

    @Override
    public boolean match(NotificationType type) {
        return type == NotificationType.EMAIL;
    }

    @Override
    public void generate(Billing billing, Customer customer) throws Exception {

        Map<String, Object> model = new HashMap<>();
        model.put("billing", billing);
        model.put("customer", customer);

        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

        EmailNotification emailNotification = new EmailNotification();
        emailNotification.setContent(content);
        emailNotification.setAddress(customer.getEmail());
        emailNotification.setStatus(NotificationStatus.NEW);
        emailNotification.setCreatedDate(Instant.now());
        emailNotificationService.add(emailNotification);
    }

    @Autowired
    public void setEmailNotificationService(EmailNotificationService emailNotificationService) {
        this.emailNotificationService = emailNotificationService;
    }

    @PostConstruct
    public void init() throws IOException {
        template = freeMarkerConfiguration.getTemplate("email.ftl");
    }

    @Autowired
    public void setFreeMarkerConfiguration(Configuration freeMarkerConfiguration) {
        this.freeMarkerConfiguration = freeMarkerConfiguration;
    }

}
