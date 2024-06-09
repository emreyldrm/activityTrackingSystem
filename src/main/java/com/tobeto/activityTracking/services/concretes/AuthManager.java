package com.tobeto.activityTracking.services.concretes;

import com.tobeto.activityTracking.core.services.JwtService;
import com.tobeto.activityTracking.core.utilities.mappers.ModelMapperService;
import com.tobeto.activityTracking.entities.User;
import com.tobeto.activityTracking.services.abstracts.AuthService;
import com.tobeto.activityTracking.services.abstracts.UserCheckService;
import com.tobeto.activityTracking.services.abstracts.UserService;
import com.tobeto.activityTracking.services.dtos.user.requests.CreateUserRequest;
import com.tobeto.activityTracking.services.dtos.user.requests.LoginRequest;
import com.tobeto.activityTracking.services.dtos.user.responses.AuthResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final ModelMapperService modelMapperService;
    private final UserCheckService userCheckService;


    @Override
    public void register(CreateUserRequest createUserRequest) throws Exception {
        if (userCheckService.checkIfRealPerson(createUserRequest)) {
            User user = new User();
            user.setName(createUserRequest.getName());
            user.setSurname(createUserRequest.getSurname());
            user.setUsername(createUserRequest.getUsername());
            user.setBirthday(createUserRequest.getBirthday());
            user.setEmail(createUserRequest.getEmail());
            user.setNationalityId(createUserRequest.getNationalityId());
            user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
            user.setAuthorities(createUserRequest.getRoles());
            userService.add(user);
        }else {
            throw new IllegalArgumentException("Not a valid person");
        }
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        if (authentication.isAuthenticated()){
            User user = userService.getUserByUsernameResponse(loginRequest.getUsername());
            AuthResponse authResponse = new AuthResponse();
            authResponse.setMessage(jwtService.generateToken(loginRequest.getUsername()));
            authResponse.setUserId(user.getId());
            return authResponse;
        }
        throw  new RuntimeException("Username or Password is wrong!");
    }
}
