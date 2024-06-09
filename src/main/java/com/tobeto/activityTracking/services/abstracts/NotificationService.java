package com.tobeto.activityTracking.services.abstracts;

import com.tobeto.activityTracking.entities.Notification;
import com.tobeto.activityTracking.services.dtos.notification.requests.AddNotificationRequest;
import com.tobeto.activityTracking.services.dtos.notification.requests.DeleteNotificationRequest;
import com.tobeto.activityTracking.services.dtos.notification.responses.GetAllNotificationByRecipientIdResponse;

import java.util.List;

public interface NotificationService {

    void add(AddNotificationRequest addNotificationRequest);
    void delete(DeleteNotificationRequest deleteNotificationRequest);
    List<GetAllNotificationByRecipientIdResponse> getAllByRecipientId(int recipientId);
    Notification getById(int id);

}
