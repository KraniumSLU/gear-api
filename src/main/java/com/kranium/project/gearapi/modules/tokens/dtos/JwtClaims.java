package com.kranium.project.gearapi.modules.tokens.dtos;


import com.kranium.project.gearapi.modules.users.domain.Role;

import java.time.Instant;

public record JwtClaims(
        String sub,
        String name,
        Role role,
        Instant issuedAt,
        Instant expiration
) {


}
