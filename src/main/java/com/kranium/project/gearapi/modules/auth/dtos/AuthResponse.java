package com.kranium.project.gearapi.modules.auth.dtos;

public record AuthResponse (
        String accessToke,
        String refreshToken
){
}
