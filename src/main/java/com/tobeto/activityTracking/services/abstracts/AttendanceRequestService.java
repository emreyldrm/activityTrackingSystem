package com.tobeto.activityTracking.services.abstracts;

import com.tobeto.activityTracking.entities.AttendanceRequest;
import com.tobeto.activityTracking.entities.Event;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.requests.AddAttendanceRequest;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.requests.DeleteAttendanceRequest;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.requests.UpdateAttendanceRequest;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.responses.GetAllAttendanceRequestByEventIdResponse;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.responses.GetAttendanceRequestByIdResponse;

import java.util.List;

public interface AttendanceRequestService {

    void add(AddAttendanceRequest addAttendanceRequest);
    void update(UpdateAttendanceRequest updateAttendanceRequest);
    void delete(DeleteAttendanceRequest deleteAttendanceRequest);
    List<GetAllAttendanceRequestByEventIdResponse> getAllByEventId(int eventId);
    GetAttendanceRequestByIdResponse getAttendanceByIdResponse(int id);
    AttendanceRequest getById(int id);
}
