package com.kranium.project.gearapi.modules.session.infrastructure;


import com.kranium.project.gearapi.modules.session.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SessionRepository extends JpaRepository<Session, UUID> {
    Optional<Session>findById(UUID uuid);
    Optional<Session>findByIp(String ipAddress);
    Optional<Session>findByDevice(String device);
}
