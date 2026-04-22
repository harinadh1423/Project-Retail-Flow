package com.project.retailproject.model;


import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "audit")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int auditId;

    String action;
    LocalDateTime timeStamp;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAuditId() {
        return auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
    }



    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = this.action;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public AuditLog() {
        super();
    }

    @Override
    public String toString() {
        return "AuditLog{" +
                "auditId=" + auditId +
                ", Action='" + action + '\'' +
                ", timeStamp=" + timeStamp +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AuditLog auditLog = (AuditLog) o;
        return auditId == auditLog.auditId && Objects.equals(action, auditLog.action) && Objects.equals(timeStamp, auditLog.timeStamp) && Objects.equals(user, auditLog.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auditId, action, timeStamp, user);
    }
}
