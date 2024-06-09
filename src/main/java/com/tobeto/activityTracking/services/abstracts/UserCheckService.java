package com.tobeto.activityTracking.services.abstracts;

import com.tobeto.activityTracking.services.dtos.user.requests.CreateUserRequest;

public interface UserCheckService {

    boolean checkIfRealPerson(CreateUserRequest createUserRequest) throws Exception;
}
