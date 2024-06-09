package com.tobeto.activityTracking.controllers;

import com.tobeto.activityTracking.services.abstracts.EventService;
import com.tobeto.activityTracking.services.dtos.event.requests.AddEventRequest;
import com.tobeto.activityTracking.services.dtos.event.requests.DeleteEventRequest;
import com.tobeto.activityTracking.services.dtos.event.requests.UpdateEventRequest;
import com.tobeto.activityTracking.services.dtos.event.responses.GetAllEventResponse;
import com.tobeto.activityTracking.services.dtos.event.responses.GetEventByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/events")
@AllArgsConstructor
public class EventsController {

    private final EventService eventService;

    @PostMapping("add")
    private void add(@RequestBody AddEventRequest addEventRequest){
        eventService.add(addEventRequest);
    }
    @PutMapping
    private void update(@RequestBody UpdateEventRequest updateEventRequest){
        eventService.update(updateEventRequest);
    }
    @DeleteMapping
    private void delete(@RequestBody DeleteEventRequest deleteEventRequest){
        eventService.delete(deleteEventRequest);
    }
    @GetMapping("allEvents")
    private List<GetAllEventResponse> getAll(){
        return eventService.getAll();
    }
    @GetMapping("{id}")
    private GetEventByIdResponse getByIdResponse(@PathVariable int id){
        return eventService.getEventByIdResponse(id);
    }

}
