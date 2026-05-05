package com.kranium.project.gearapi.modules.identity.api.dtos;

public record AuthResponse (
        String accessToken,
        String refreshToken
){
}
