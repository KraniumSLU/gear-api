package com.kranium.project.gearapi.modules.session.application;

import com.kranium.project.gearapi.modules.session.domain.Session;
import com.kranium.project.gearapi.modules.session.metadataExtract.dtos.ClientMetadataDTO;
import com.kranium.project.gearapi.modules.users.domain.User;

public interface SessionService {
    Session create(User user, ClientMetadataDTO clientMetadataDTO);
}
