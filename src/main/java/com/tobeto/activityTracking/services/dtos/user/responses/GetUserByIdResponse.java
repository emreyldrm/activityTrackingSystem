package com.tobeto.activityTracking.services.dtos.user.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserByIdResponse {

    private int id;
    private String username;
    private String fullName;
    private String email;
}
