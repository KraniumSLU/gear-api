package com.kranium.project.gearapi.modules.users.service;

import com.kranium.project.gearapi.modules.users.domain.User;
import com.kranium.project.gearapi.modules.users.domain.UserAuthenticated;
import com.kranium.project.gearapi.modules.users.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserAuthenticated(user);
    }
}
