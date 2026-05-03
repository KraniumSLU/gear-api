package com.kranium.project.gearapi.modules.auth.services;

import com.kranium.project.gearapi.modules.auth.dtos.AuthRequest;
import com.kranium.project.gearapi.modules.auth.dtos.AuthResponse;
import com.kranium.project.gearapi.modules.tokens.service.JwtService;
import com.kranium.project.gearapi.modules.users.domain.User;
import com.kranium.project.gearapi.modules.users.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtuhServiceImpl implements AuthSerivce{
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.username(),
                authRequest.password()
        ));
        User user = userRepository.findByUsername(authRequest.username()).orElseThrow();

        String acessToken = jwtService.generateToken(user);

        String refreshToken;
    }
}
