package com.tobeto.activityTracking.services.abstracts;

import com.tobeto.activityTracking.services.dtos.user.requests.CreateUserRequest;
import com.tobeto.activityTracking.services.dtos.user.requests.LoginRequest;
import com.tobeto.activityTracking.services.dtos.user.responses.AuthResponse;

public interface AuthService {

    void register(CreateUserRequest createUserRequest) throws Exception;
    AuthResponse login(LoginRequest loginRequest);
}
