package com.example.notification.service;

import com.example.notification.dto.NotificationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateNotifyEventProducer {

    private final KafkaTemplate<String, NotificationDTO> notifyKafkaTemplate;

    @Value("${kafka.activity.topic.name}")
    private String topicName;
    private void sendMessage(NotificationDTO notificationDTO) {
        notifyKafkaTemplate.send(topicName, notificationDTO);
    }
    public void create(NotificationDTO notificationDTO) {
        sendMessage(notificationDTO);
    }
}
