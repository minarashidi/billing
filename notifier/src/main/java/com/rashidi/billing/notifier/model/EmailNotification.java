package com.rashidi.billing.notifier.model;

import javax.persistence.*;
import java.time.Instant;

/**
 * An entity for representing a EmailNotification.
 *
 * @author Mina Rashidi
 */
@Entity
@Table(name = "EMAIL_NOTIFICATION")
@SequenceGenerator(name = "S_EMAIL_NOTIFICATION", sequenceName = "S_EMAIL_NOTIFICATION", allocationSize = 1)
public class EmailNotification {

    private long id;
    private String content;
    private String address;
    private NotificationStatus status;
    private Instant createdDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_EMAIL_NOTIFICATION")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    private Instant changedDate;

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

    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
