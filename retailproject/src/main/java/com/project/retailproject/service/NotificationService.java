package com.project.retailproject.service;

import com.project.retailproject.db.NotificationRepository;
import com.project.retailproject.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private  NotificationRepository notificationRepository;

    public Notification insertNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification updateNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void deleteNotification(int id) {
        notificationRepository.deleteById((long) id);
    }

    public Notification getNotification(int id) {
        return notificationRepository.findById((long) id).orElse(null);
    }

    public List<Notification> getAllNotification() {
        return notificationRepository.findAll();
    }

    public Page<Notification> getAllNotification(Pageable pageable) {
        return notificationRepository.findAll(pageable);
    }
}
