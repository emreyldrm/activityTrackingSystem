package com.tobeto.activityTracking.services.dtos.user.requests;

import com.tobeto.activityTracking.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String email;
    private String username;
    private String password;
    private List<Role> roles;
    private String name;
    private String surname;
    private String nationalityId;
    private LocalDate birthday;
}
