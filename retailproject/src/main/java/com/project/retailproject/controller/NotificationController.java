package com.project.retailproject.controller;

import com.project.retailproject.dto.NotificationDTO;
import com.project.retailproject.dto.NotificationResponseDTO;
import com.project.retailproject.model.Notification;
import com.project.retailproject.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/insertNotification")
    public ResponseEntity<NotificationResponseDTO> insertNotification(@RequestBody NotificationDTO notificationDTO) {
        Notification n = notificationService.insertNotification(notificationDTO.getNotification());
        NotificationResponseDTO dto = new NotificationResponseDTO();
        dto.setNotification(n);
        dto.setStatusCode(201);
        dto.setMessage("Notification created successfully");
        return ResponseEntity.status(201).body(dto);
    }

    @PutMapping("/updateNotification")
    public ResponseEntity<NotificationResponseDTO> updateNotification(@RequestBody NotificationDTO notificationDTO) {
        Notification n = notificationService.updateNotification(notificationDTO.getNotification());
        NotificationResponseDTO dto = new NotificationResponseDTO();
        dto.setNotification(n);
        dto.setStatusCode(201);
        dto.setMessage("Notification updated successfully");
        return ResponseEntity.status(201).body(dto);
    }

    @GetMapping("/getAllNotifications")
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotification();
        return ResponseEntity.status(200).body(notifications);
    }

    @GetMapping("/getNotification/{id}")
    public ResponseEntity<NotificationResponseDTO> getNotification(@PathVariable int id) {
        Notification n = notificationService.getNotification(id);
        NotificationResponseDTO dto = new NotificationResponseDTO();
        dto.setNotification(n);
        dto.setStatusCode(200);
        dto.setMessage("Found notification with ID: " + id);
        return ResponseEntity.status(200).body(dto);
    }

    @DeleteMapping("/deleteNotification/{id}")
    public String deleteNotification(@PathVariable int id) {
        notificationService.deleteNotification(id);
        return "Notification with ID deleted successfully";
    }

    public ResponseEntity<Page<Notification>> getNotificationsByPage(@RequestParam(defaultValue = "0") int page,
                                                                     @RequestParam(defaultValue = "10") int size,
                                                                     @RequestParam(defaultValue = "notificationId") String sorting,
                                                                     @RequestParam(defaultValue = "true") boolean asc) {
        Sort sort = asc
                ? Sort.by(sorting).ascending()
                : Sort.by(sorting).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Notification> notifications = notificationService.getAllNotification(pageable);
        return ResponseEntity.ok().body(notifications);
    }
}
