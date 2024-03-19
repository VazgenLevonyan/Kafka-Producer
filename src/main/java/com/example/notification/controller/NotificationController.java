package com.example.notification.controller;

import com.example.notification.dto.NotificationDTO;
import com.example.notification.service.CreateNotifyEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    CreateNotifyEventProducer createNotifyEventProducer;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody NotificationDTO notificationDTO) {
        createNotifyEventProducer.create(notificationDTO);
        return ResponseEntity.ok().build();
    }
}
