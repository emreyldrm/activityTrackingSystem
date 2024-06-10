package com.tobeto.activityTracking.controllers;

import com.tobeto.activityTracking.services.abstracts.AttendanceRequestService;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.requests.AddAttendanceRequest;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.requests.DeleteAttendanceRequest;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.requests.UpdateAttendanceRequest;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.responses.GetAllAttendanceRequestByEventIdResponse;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.responses.GetAllAttendanceRequestByRecipientIdResponse;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.responses.GetAttendanceRequestByIdResponse;
import com.tobeto.activityTracking.services.dtos.notification.responses.GetAllNotificationByRecipientIdResponse;
import com.tobeto.activityTracking.services.dtos.user.requests.CreateUserRequest;
import com.tobeto.activityTracking.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.activityTracking.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.activityTracking.services.dtos.user.responses.GetAllUserResponse;
import com.tobeto.activityTracking.services.dtos.user.responses.GetUserByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/attendanceRequests")
@AllArgsConstructor
@CrossOrigin
public class AttendanceRequestsController {

    private final AttendanceRequestService attendanceRequestService;

    @PostMapping("add")
    private void add(@RequestBody AddAttendanceRequest addAttendanceRequest){
        attendanceRequestService.add(addAttendanceRequest);
    }
    @PutMapping
    private void update(@RequestBody UpdateAttendanceRequest updateAttendanceRequest){
        attendanceRequestService.update(updateAttendanceRequest);
    }
    @DeleteMapping
    private void delete(@RequestBody DeleteAttendanceRequest deleteAttendanceRequest){
        attendanceRequestService.delete(deleteAttendanceRequest);
    }
    @GetMapping("allAttendance/event/{id}")
    private List<GetAllAttendanceRequestByEventIdResponse> getAllByEventId(@PathVariable int id){
        return attendanceRequestService.getAllByEventId(id);
    }
    @GetMapping("allAttendance/recipient/{id}")
    private List<GetAllAttendanceRequestByRecipientIdResponse> getAllByRecipientId(@PathVariable int id){
        return attendanceRequestService.getAllByRecipientId(id);
    }
    @GetMapping("{id}")
    private GetAttendanceRequestByIdResponse getByIdResponse(@PathVariable int id){
        return attendanceRequestService.getAttendanceByIdResponse(id);
    }

}
