package com.kranium.project.gearapi.modules.identity.api.dtos;

public record AuthRequest(
        String username,
        String password
) {
}
