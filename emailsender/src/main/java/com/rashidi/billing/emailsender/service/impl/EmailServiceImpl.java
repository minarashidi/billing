package com.rashidi.billing.emailsender.service.impl;

import com.rashidi.billing.emailsender.model.EmailNotification;
import com.rashidi.billing.emailsender.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.MimeMessage;

@Transactional
@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender mailSender;

    @Value("${mail.subject}")
    private String subject;

    @Value("${mail.from}")
    private String from;

    @Override
    public void send(EmailNotification emailNotification) {
        try {
            mailSender.send(getMessagePreparator(emailNotification));
        }catch (Exception e){
          e.printStackTrace();
        }
    }

    private MimeMessagePreparator getMessagePreparator(EmailNotification emailNotification) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setSubject(subject);
                helper.setFrom(from);
                helper.setTo(emailNotification.getAddress());
                helper.setText(emailNotification.getContent(), true);
            }
        };
        return preparator;
    }

    @Autowired
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

}
