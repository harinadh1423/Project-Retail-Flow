package com.project.retailproject.dto;

import com.project.retailproject.model.Notification;

public class NotificationResponseDTO {

    private Notification  notification;
    private String message;
    private int statusCode;

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
