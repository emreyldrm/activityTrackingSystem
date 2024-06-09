package com.tobeto.activityTracking.services.dtos.attendanceRequest.requests;


import com.tobeto.activityTracking.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAttendanceRequest {

    private int id;
    private Status status;
}
