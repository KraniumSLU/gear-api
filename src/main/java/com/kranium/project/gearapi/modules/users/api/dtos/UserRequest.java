package com.kranium.project.gearapi.modules.users.api.dtos;

import com.kranium.project.gearapi.modules.users.domain.Role;
import com.kranium.project.gearapi.modules.users.domain.User;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserRequest(
        @NotBlank(message = "Username é obrigatório")
        @Size(min = 3, max = 50, message = "Username deve ter entre 3 e 50 caracteres")
        String username,
        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 8, max = 100, message = "Senha deve ter no mínimo 8 caracteres")
        String password,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        String email,
        @NotNull(message = "Role é obrigatória")
        Role role,
        @NotNull(message = "Status ativo é obrigatório")
        Boolean status,
        @NotNull(message = "Data de nascimento é obrigatória")
        @Past(message = "Data de nascimento deve estar no passado")
        LocalDate dataNasci
){
    public static User toEntity(UserRequest userRequest){
        return new User(
                userRequest.username,
                userRequest.password,
                userRequest.email,
                userRequest.role,
                userRequest.status,
                userRequest.dataNasci
        );
    }
}