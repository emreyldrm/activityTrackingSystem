package com.tobeto.activityTracking.services.dtos.attendanceRequest.responses;

import com.tobeto.activityTracking.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAttendanceRequestByIdResponse {

    private int id;
    private int userId;
    private int recipientId;
    private int eventId;
    private Status status;
}
