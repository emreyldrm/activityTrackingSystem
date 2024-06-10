package com.tobeto.activityTracking.services.abstracts;


import com.tobeto.activityTracking.entities.Event;
import com.tobeto.activityTracking.services.dtos.event.requests.AddEventRequest;
import com.tobeto.activityTracking.services.dtos.event.requests.DeleteEventRequest;
import com.tobeto.activityTracking.services.dtos.event.requests.UpdateEventRequest;
import com.tobeto.activityTracking.services.dtos.event.responses.GetAllEventByOwnerIdResponse;
import com.tobeto.activityTracking.services.dtos.event.responses.GetAllEventResponse;
import com.tobeto.activityTracking.services.dtos.event.responses.GetEventByIdResponse;

import java.util.List;

public interface EventService {

    void add(AddEventRequest addEventRequest);
    void update(UpdateEventRequest updateEventRequest);
    void delete(DeleteEventRequest deleteEventRequest);
    List<GetAllEventResponse> getAll();
    List<GetAllEventByOwnerIdResponse> getAllByOwnerId(int ownerId);
    GetEventByIdResponse getEventByIdResponse(int id);
    Event getById(int id);
}
