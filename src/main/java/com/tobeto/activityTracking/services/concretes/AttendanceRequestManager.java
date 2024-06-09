package com.tobeto.activityTracking.services.concretes;

import com.tobeto.activityTracking.core.utilities.mappers.ModelMapperService;
import com.tobeto.activityTracking.entities.AttendanceRequest;
import com.tobeto.activityTracking.entities.Event;
import com.tobeto.activityTracking.entities.Status;
import com.tobeto.activityTracking.repositories.AttendanceRequestRepository;
import com.tobeto.activityTracking.services.abstracts.AttendanceRequestService;
import com.tobeto.activityTracking.services.abstracts.EventService;
import com.tobeto.activityTracking.services.abstracts.UserService;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.requests.AddAttendanceRequest;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.requests.DeleteAttendanceRequest;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.requests.UpdateAttendanceRequest;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.responses.GetAllAttendanceRequestByEventIdResponse;
import com.tobeto.activityTracking.services.dtos.attendanceRequest.responses.GetAttendanceRequestByIdResponse;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AttendanceRequestManager implements AttendanceRequestService {

    private final AttendanceRequestRepository attendanceRequestRepository;
    private final UserService userService;
    private final EventService eventService;
    private final ModelMapperService modelMapperService;


    @Override
    public void add(AddAttendanceRequest addAttendanceRequest) {
        eventService.getById(addAttendanceRequest.getEventId());
        userService.getById(addAttendanceRequest.getUserId());
        Status statusDefault = Status.PENDING;
        AttendanceRequest attendanceRequest = this.modelMapperService.forRequest().map(addAttendanceRequest, AttendanceRequest.class);
        attendanceRequest.setStatus(statusDefault);
        this.attendanceRequestRepository.save(attendanceRequest);
    }

    @Override
    public void update(UpdateAttendanceRequest updateAttendanceRequest) {
        AttendanceRequest oldAttendanceRequest = this.getById(updateAttendanceRequest.getId());

        AttendanceRequest attendanceRequestToUpdate = this.modelMapperService.forRequest().map(updateAttendanceRequest, AttendanceRequest.class);
        attendanceRequestToUpdate.setUser(oldAttendanceRequest.getUser());
        attendanceRequestToUpdate.setEvent(oldAttendanceRequest.getEvent());
        this.attendanceRequestRepository.save(attendanceRequestToUpdate);

    }

    @Override
    public void delete(DeleteAttendanceRequest deleteAttendanceRequest) {
        AttendanceRequest attendanceRequestToDelete = this.getById(deleteAttendanceRequest.getId());
        attendanceRequestRepository.delete(attendanceRequestToDelete);
    }

    @Override
    public List<GetAllAttendanceRequestByEventIdResponse> getAllByEventId(int eventId) {
        Event event = eventService.getById(eventId);
        List<AttendanceRequest> attendanceRequests = attendanceRequestRepository.findByEvent(event);
        List<GetAllAttendanceRequestByEventIdResponse> attendanceRequestByEventIdResponses = attendanceRequests.stream()
                .map(attendanceRequest -> this.modelMapperService.forResponse().map(attendanceRequest, GetAllAttendanceRequestByEventIdResponse.class))
                .toList();
        return attendanceRequestByEventIdResponses;
    }

    @Override
    public GetAttendanceRequestByIdResponse getAttendanceByIdResponse(int id) {
        AttendanceRequest attendanceRequest = this.getById(id);
        GetAttendanceRequestByIdResponse getAttendanceRequestByIdResponse = this.modelMapperService.forResponse()
                .map(attendanceRequest, GetAttendanceRequestByIdResponse.class);

        return getAttendanceRequestByIdResponse;
    }

    @Override
    public AttendanceRequest getById(int id) {
        return attendanceRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no attendance request with this id!"));
    }
}
