package com.kranium.project.gearapi.modules.users.repositories;

import com.kranium.project.gearapi.modules.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User>findById(UUID uuid);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
