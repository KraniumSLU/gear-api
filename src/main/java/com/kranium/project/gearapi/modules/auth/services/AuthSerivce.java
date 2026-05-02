package com.kranium.project.gearapi.modules.auth.services;

import com.kranium.project.gearapi.modules.auth.dtos.AuthRequest;
import com.kranium.project.gearapi.modules.auth.dtos.AuthResponse;

public interface AuthSerivce {
    AuthResponse authenticate(AuthRequest authRequest);
}
