package com.tobeto.activityTracking.controllers;

import com.tobeto.activityTracking.entities.User;
import com.tobeto.activityTracking.services.abstracts.UserService;
import com.tobeto.activityTracking.services.dtos.event.requests.AddEventRequest;
import com.tobeto.activityTracking.services.dtos.event.requests.DeleteEventRequest;
import com.tobeto.activityTracking.services.dtos.event.requests.UpdateEventRequest;
import com.tobeto.activityTracking.services.dtos.event.responses.GetAllEventResponse;
import com.tobeto.activityTracking.services.dtos.event.responses.GetEventByIdResponse;
import com.tobeto.activityTracking.services.dtos.user.requests.CreateUserRequest;
import com.tobeto.activityTracking.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.activityTracking.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.activityTracking.services.dtos.user.responses.GetAllUserResponse;
import com.tobeto.activityTracking.services.dtos.user.responses.GetUserByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UsersController {

    private final UserService userService;

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    private void add(@RequestBody User createUserRequest){
        userService.add(createUserRequest);
    }
    @PutMapping
    private void update(@RequestBody UpdateUserRequest updateUserRequest){
        userService.update(updateUserRequest);
    }
    @DeleteMapping
    private void delete(@RequestBody DeleteUserRequest deleteUserRequest){
        userService.delete(deleteUserRequest);
    }
    @GetMapping("allUsers")
    private List<GetAllUserResponse> getAll(){
        return userService.getAll();
    }
    @GetMapping("{id}")
    private GetUserByIdResponse getByIdResponse(@PathVariable int id){
        return userService.getUserByIdResponse(id);
    }

}
