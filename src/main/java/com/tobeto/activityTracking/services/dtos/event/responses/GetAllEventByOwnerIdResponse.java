package com.tobeto.activityTracking.services.dtos.event.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEventByOwnerIdResponse {

    private int id;
    private String name;
    private LocalDate date;
    private LocalTime time;
    private String location;
    private int ownerId;
}
