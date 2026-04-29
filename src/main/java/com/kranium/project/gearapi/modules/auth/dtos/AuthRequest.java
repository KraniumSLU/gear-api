package com.kranium.project.gearapi.modules.auth.dtos;

public record AuthRequest(
        String username,
        String password
) {
}
