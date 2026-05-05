package com.kranium.project.gearapi.modules.users.api.dtos;

import com.kranium.project.gearapi.modules.identity.inheritanceClass.dtos.GenericMapper;
import com.kranium.project.gearapi.modules.users.domain.User;

import java.util.Objects;

public class UserMapper implements GenericMapper<User,UserResponse,UserRequest> {
    @Override
    public User toEntity(UserRequest request) {
        Objects.requireNonNull(request,"Request cannot be null");
        User entity=new User();
        entity.setUsername(request.username());
        entity.setPassword(request.password());
        entity.setEmail(request.email());
        entity.setRole(request.role());
        entity.setStatus(request.status());
        return entity;

    }

    @Override
    public UserResponse toResponse(User entity) {
        Objects.requireNonNull(entity,"Entity cannot be null");
        return new UserResponse(
                entity.getUsername(),
                entity.getEmail(),
                entity.getRole(),
                entity.getStatus(),
                entity.getDataNasci(),
                entity.getUuid(),
                entity.getLastModifiedBy(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
