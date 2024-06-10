package com.tobeto.activityTracking.services.concretes;

import com.tobeto.activityTracking.core.utilities.mappers.ModelMapperService;
import com.tobeto.activityTracking.entities.Event;
import com.tobeto.activityTracking.entities.User;
import com.tobeto.activityTracking.repositories.EventRepository;
import com.tobeto.activityTracking.services.abstracts.EventService;
import com.tobeto.activityTracking.services.abstracts.UserService;
import com.tobeto.activityTracking.services.dtos.event.requests.AddEventRequest;
import com.tobeto.activityTracking.services.dtos.event.requests.DeleteEventRequest;
import com.tobeto.activityTracking.services.dtos.event.requests.UpdateEventRequest;
import com.tobeto.activityTracking.services.dtos.event.responses.GetAllEventByOwnerIdResponse;
import com.tobeto.activityTracking.services.dtos.event.responses.GetAllEventResponse;
import com.tobeto.activityTracking.services.dtos.event.responses.GetEventByIdResponse;
import com.tobeto.activityTracking.services.dtos.notification.responses.GetAllNotificationByRecipientIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventManager implements EventService {

    private final EventRepository eventRepository;
    private final UserService userService;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(AddEventRequest addEventRequest) {
        userService.getById(addEventRequest.getOwnerId());

        Event event = this.modelMapperService.forRequest().map(addEventRequest, Event.class);
        this.eventRepository.save(event);
    }

    @Override
    public void update(UpdateEventRequest updateEventRequest) {
        this.getById(updateEventRequest.getId());

        Event eventToUpdate = this.modelMapperService.forRequest().map(updateEventRequest, Event.class);
        this.eventRepository.save(eventToUpdate);
    }

    @Override
    public void delete(DeleteEventRequest deleteEventRequest) {
        Event eventToDelete = this.getById(deleteEventRequest.getId());
        eventRepository.delete(eventToDelete);
    }

    @Override
    public List<GetAllEventResponse> getAll() {
        List<Event> events = eventRepository.findAll();
        List<GetAllEventResponse> eventResponses = events.stream()
                .map(event -> this.modelMapperService.forResponse().map(event, GetAllEventResponse.class))
                .toList();
        return eventResponses;
    }

    @Override
    public List<GetAllEventByOwnerIdResponse> getAllByOwnerId(int ownerId) {
        User owner = userService.getById(ownerId);
        List<Event> events = eventRepository.findByOwner(owner);
        List<GetAllEventByOwnerIdResponse> eventByOwnerIdResponses = events.stream()
                .map(event -> this.modelMapperService.forResponse().map(event, GetAllEventByOwnerIdResponse.class))
                .toList();
        return eventByOwnerIdResponses;
    }

    @Override
    public GetEventByIdResponse getEventByIdResponse(int id) {
        Event event = this.getById(id);
        GetEventByIdResponse getEventByIdResponse = this.modelMapperService.forResponse()
                .map(event, GetEventByIdResponse.class);

        return getEventByIdResponse;
    }

    @Override
    public Event getById(int id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no event with this id!"));
    }
}
