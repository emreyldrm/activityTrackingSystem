package com.tobeto.activityTracking.services.dtos.notification.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddNotificationRequest {

    private int senderId;
    private int recipientId;
    private int eventId;
    private String message;
    private LocalDateTime notificationTime;
}
