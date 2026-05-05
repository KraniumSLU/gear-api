package com.kranium.project.gearapi.modules.users.infrastructure.persistence;

import com.kranium.project.gearapi.modules.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User>findById(UUID uuid);
    Optional<User>findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
