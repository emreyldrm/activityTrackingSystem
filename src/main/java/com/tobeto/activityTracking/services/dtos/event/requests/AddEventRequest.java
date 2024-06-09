package com.tobeto.activityTracking.services.dtos.event.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEventRequest {

    private String name;
    private LocalDate date;
    private LocalTime time;
    private String location;
    private int ownerId;

}
