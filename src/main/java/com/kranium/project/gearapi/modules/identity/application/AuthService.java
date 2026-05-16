package com.kranium.project.gearapi.modules.identity.application;

import com.kranium.project.gearapi.modules.identity.api.dtos.AuthRequest;
import com.kranium.project.gearapi.modules.identity.api.dtos.AuthResponse;

public interface AuthService {
    AuthResponse authenticate(AuthRequest authRequest);
}
