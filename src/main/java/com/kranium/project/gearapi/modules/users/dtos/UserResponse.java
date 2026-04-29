package com.kranium.project.gearapi.modules.users.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
        "ativo",
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
        Boolean ativo,
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
                user.getAtivo(),
                user.getDataNasci(),
                user.getUuid(),
                user.getLastModifiedBy(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

}
