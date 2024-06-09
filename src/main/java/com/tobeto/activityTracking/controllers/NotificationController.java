package com.tobeto.activityTracking.controllers;

import com.tobeto.activityTracking.services.abstracts.NotificationService;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.requests.AddAttendanceRequest;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.requests.DeleteAttendanceRequest;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.responses.GetAllAttendanceRequestByEventIdResponse;
import com.tobeto.activityTracking.services.dtos.notification.requests.AddNotificationRequest;
import com.tobeto.activityTracking.services.dtos.notification.requests.DeleteNotificationRequest;
import com.tobeto.activityTracking.services.dtos.notification.responses.GetAllNotificationByRecipientIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notifications")
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("add")
    private void add(@RequestBody AddNotificationRequest addNotificationRequest){
        notificationService.add(addNotificationRequest);
    }
    @DeleteMapping
    private void delete(@RequestBody DeleteNotificationRequest deleteNotificationRequest){
        notificationService.delete(deleteNotificationRequest);
    }
    @GetMapping("allAttendance/recipient/{id}")
    private List<GetAllNotificationByRecipientIdResponse> getAllByRecipientId(@PathVariable int id){
        return notificationService.getAllByRecipientId(id);
    }
}
