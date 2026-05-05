package com.kranium.project.gearapi.modules.identity.application;

import com.kranium.project.gearapi.modules.identity.api.dtos.AuthRequest;
import com.kranium.project.gearapi.modules.identity.api.dtos.AuthResponse;

public interface AuthSerivce {
    AuthResponse authenticate(AuthRequest authRequest);
}
