package com.tobeto.activityTracking.services.concretes;

import com.tobeto.activityTracking.core.utilities.mappers.ModelMapperService;
import com.tobeto.activityTracking.entities.User;
import com.tobeto.activityTracking.repositories.UserRepository;
import com.tobeto.activityTracking.services.abstracts.UserCheckService;
import com.tobeto.activityTracking.services.abstracts.UserService;
import com.tobeto.activityTracking.services.dtos.user.requests.CreateUserRequest;
import com.tobeto.activityTracking.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.activityTracking.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.activityTracking.services.dtos.user.responses.GetAllUserResponse;
import com.tobeto.activityTracking.services.dtos.user.responses.GetUserByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public void add(User user){

            this.userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User oldUser = this.getById(updateUserRequest.getId());

        User userToUpdate = this.modelMapperService.forRequest().map(updateUserRequest, User.class);
        userToUpdate.setName(oldUser.getName());
        userToUpdate.setSurname(oldUser.getSurname());
        userToUpdate.setEmail(oldUser.getEmail());
        userToUpdate.setPassword(oldUser.getPassword());
        userToUpdate.setNationalityId(oldUser.getNationalityId());
        userToUpdate.setBirthday(oldUser.getBirthday());
        this.userRepository.save(userToUpdate);
    }

    @Override
    public void delete(DeleteUserRequest deleteUserRequest) {
        User userToDelete = this.getById(deleteUserRequest.getId());
        userRepository.delete(userToDelete);

    }

    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUserResponse> userResponses = users.stream()
                .map(user -> this.modelMapperService.forResponse().map(user, GetAllUserResponse.class))
                .toList();
        return userResponses;
    }

    @Override
    public GetUserByIdResponse getUserByIdResponse(int id) {
        User user = this.getById(id);
        GetUserByIdResponse getUserByIdResponse = this.modelMapperService.forResponse()
                .map(user, GetUserByIdResponse.class);

        return getUserByIdResponse;
    }

    @Override
    public User getUserByUsernameResponse(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user found"));
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no user with this id!"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user found"));
    }
}
