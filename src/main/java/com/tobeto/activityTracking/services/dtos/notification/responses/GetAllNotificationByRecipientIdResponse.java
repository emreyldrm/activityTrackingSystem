package com.tobeto.activityTracking.services.dtos.notification.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllNotificationByRecipientIdResponse {

    private int id;
    private int senderId;
    private int recipientId;
    private int eventId;
    private String message;
    private LocalDateTime notificationTime;
}
