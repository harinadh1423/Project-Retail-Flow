package com.project.retailproject.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;
    String userName;
    String  roles;
    String  email;
    String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    AuditLog auditLog;

    public AuditLog getAuditLog() {
        return auditLog;
    }

    public void setAuditLog(AuditLog auditLog) {
        this.auditLog = auditLog;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", roles='" + roles + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", auditLog=" + auditLog +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && phoneNumber == user.phoneNumber && Objects.equals(userName, user.userName) && Objects.equals(roles, user.roles) && Objects.equals(email, user.email) && Objects.equals(auditLog, user.auditLog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, roles, email, phoneNumber, auditLog);
    }
}
