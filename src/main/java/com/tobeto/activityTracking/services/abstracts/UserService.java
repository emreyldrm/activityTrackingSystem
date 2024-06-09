package com.tobeto.activityTracking.services.abstracts;


import com.tobeto.activityTracking.entities.User;
import com.tobeto.activityTracking.services.dtos.user.requests.CreateUserRequest;
import com.tobeto.activityTracking.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.activityTracking.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.activityTracking.services.dtos.user.responses.GetAllUserResponse;
import com.tobeto.activityTracking.services.dtos.user.responses.GetUserByIdResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void add(User user);
    void update(UpdateUserRequest updateUserRequest);
    void delete(DeleteUserRequest deleteUserRequest);
    List<GetAllUserResponse> getAll();
    GetUserByIdResponse getUserByIdResponse(int id);
    User getUserByUsernameResponse(String username);
    User getById(int id);
}
