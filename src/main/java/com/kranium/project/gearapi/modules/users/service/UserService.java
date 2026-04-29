package com.kranium.project.gearapi.modules.users.service;

import com.kranium.project.gearapi.modules.users.dtos.UserRequest;
import com.kranium.project.gearapi.modules.users.dtos.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Page<UserResponse> findUsers(Pageable pageable);
    UserResponse findUserById(UUID uuid);
    UserResponse createUser(UserRequest userRequest);
    UserResponse updateUser(UUID uuid, UserRequest userRequest);
    void deleteUser(UUID uuid);
    void validateEmail(String email);
    void validateUsername(String username);
}
