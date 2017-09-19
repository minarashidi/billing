package com.rashidi.billing.notifier.model;

import javax.persistence.*;
import java.time.Instant;

/**
 * An entity for representing a SmsNotification.
 *
 * @author Mina rashidi
 */
@Entity
@Table(name = "SMS_NOTIFICATION")
@SequenceGenerator(name = "NOTIFIER.S_SMS_NOTIFICATION", sequenceName = "NOTIFIER.S_SMS_NOTIFICATION", allocationSize = 1)
public class SmsNotification {

    private long id;
    private String content;
    private String mobile;
    private NotificationStatus status;
    private Instant createdDate;
    private Instant changedDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTIFIER.S_SMS_NOTIFICATION")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "MOBILE")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
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
