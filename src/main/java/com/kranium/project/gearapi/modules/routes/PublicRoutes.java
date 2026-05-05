package com.kranium.project.gearapi.modules.routes;

public final class PublicRoutes {
    //O Swagger UI é uma aplicação frontend servida pelo Spring.
    public static final String [] ENDPOINTS = {
            "/auth/**",
            "/swagger-ui/**",
            "/v3/api-docs/**"
    };
}
