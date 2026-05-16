package com.kranium.project.gearapi.modules.session.metadataExtract.dtos;

public record ClientMetadataDTO(
        String ipAddress,
        String userAgent,
        String device
) {
}
