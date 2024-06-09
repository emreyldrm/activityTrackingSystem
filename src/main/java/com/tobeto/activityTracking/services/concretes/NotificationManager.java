package com.tobeto.activityTracking.services.concretes;

import com.tobeto.activityTracking.core.utilities.mappers.ModelMapperService;
import com.tobeto.activityTracking.entities.Notification;
import com.tobeto.activityTracking.entities.User;
import com.tobeto.activityTracking.repositories.NotificationRepository;
import com.tobeto.activityTracking.services.abstracts.EventService;
import com.tobeto.activityTracking.services.abstracts.NotificationService;
import com.tobeto.activityTracking.services.abstracts.UserService;
import com.tobeto.activityTracking.services.dtos.notification.requests.AddNotificationRequest;
import com.tobeto.activityTracking.services.dtos.notification.requests.DeleteNotificationRequest;
import com.tobeto.activityTracking.services.dtos.notification.responses.GetAllNotificationByRecipientIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotificationManager implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserService userService;
    private final EventService eventService;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(AddNotificationRequest addNotificationRequest) {
        eventService.getById(addNotificationRequest.getEventId());
        userService.getById(addNotificationRequest.getSenderId());
        userService.getById(addNotificationRequest.getRecipientId());

        Notification notification = this.modelMapperService.forRequest().map(addNotificationRequest, Notification.class);
        this.notificationRepository.save(notification);

    }

    @Override
    public void delete(DeleteNotificationRequest deleteNotificationRequest) {
       Notification notificationToDelete =  this.getById(deleteNotificationRequest.getId());
       this.notificationRepository.delete(notificationToDelete);

    }

    @Override
    public List<GetAllNotificationByRecipientIdResponse> getAllByRecipientId(int recipientId) {
        User recipient = userService.getById(recipientId);
        List<Notification> notifications = notificationRepository.findByRecipient(recipient);
        List<GetAllNotificationByRecipientIdResponse> notificationByRecipientIdResponses = notifications.stream()
                .map(notification -> this.modelMapperService.forResponse().map(notification, GetAllNotificationByRecipientIdResponse.class))
                .toList();

        return notificationByRecipientIdResponses;
    }

    @Override
    public Notification getById(int id) {
        return this.notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no notification with this id"));
    }
}
