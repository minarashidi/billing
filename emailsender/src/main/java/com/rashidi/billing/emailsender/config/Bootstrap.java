package com.rashidi.billing.emailsender.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Bootstrap {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(AppConfig.class, QuartzConfig.class);
    }
}
