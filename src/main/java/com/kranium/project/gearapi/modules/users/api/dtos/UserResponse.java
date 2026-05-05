package com.kranium.project.gearapi.modules.users.api.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.kranium.project.gearapi.modules.users.domain.Role;
import com.kranium.project.gearapi.modules.users.domain.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@JsonPropertyOrder({
        "username",
        "email",
        "role",
        "status",
        "dataNasci",
        "uuid",
        "lastModifiedBy",
        "createdAt",
        "updateAt"
})
public record UserResponse(
        String username,
        String email,
        Role role,
        Boolean status,
        LocalDate dataNasci,
        UUID uuid,
        String lastModifiedBy,
        LocalDateTime createdAt,
        LocalDateTime updateAt
) {
    public static UserResponse toResponse(User user){
        return new UserResponse(
                user.getUsername(),
                user.getEmail(),
                user.getRole(),
                user.getStatus(),
                user.getDataNasci(),
                user.getUuid(),
                user.getLastModifiedBy(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

}
