package com.kranium.project.gearapi.modules.session.application;

import com.kranium.project.gearapi.modules.session.domain.Session;
import com.kranium.project.gearapi.modules.session.infrastructure.SessionRepository;
import com.kranium.project.gearapi.modules.session.metadataExtract.dtos.ClientMetadataDTO;
import com.kranium.project.gearapi.modules.users.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class SessionServiceImp implements SessionService{
    private final SessionRepository repository;
    @Override
    public Session create(User user, ClientMetadataDTO clientMetadataDTO) {
        Session session = Session
                .builder()
                .user(user)
                .startedAt(Instant.now())
                .lastAccess(Instant.now())
                .active(true)
                .ipAddress(clientMetadataDTO.ipAddress())
                .userAgent(clientMetadataDTO.userAgent())
                .device(clientMetadataDTO.device()).build();
        return repository.save(session);
    }
}
