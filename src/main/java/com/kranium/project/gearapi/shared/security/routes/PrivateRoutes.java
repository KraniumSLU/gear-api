package com.kranium.project.gearapi.shared.security.routes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class PrivateRoutes {

    public static String [] ENDPOINTS = {

            /*
             * WebSocket privado
             */
            "/ws/private/**",

            /*
             * Comunicação MQTT interna
             */
            "/mqtt/**",

            /*
             * Sensores internos
             */
            "/sensor/**",

            /*
             * Dispositivos IoT
             */
            "/device/**",

            /*
             * APIs internas
             */
            "/internal/**"
    };
}
