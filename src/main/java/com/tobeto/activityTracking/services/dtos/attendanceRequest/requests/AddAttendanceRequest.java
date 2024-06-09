package com.tobeto.activityTracking.services.dtos.attendanceRequest.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAttendanceRequest {

    private int userId;
    private int eventId;

}
