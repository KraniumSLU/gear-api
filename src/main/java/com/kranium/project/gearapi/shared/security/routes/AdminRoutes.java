package com.kranium.project.gearapi.shared.security.routes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class AdminRoutes {
    public static  String [ ] ENDPOINTS = {
            /*
                 * Painel administrativo
                 */
            "/admin/**",

            /*
             * Gestão de usuários
             */
            "/management/**",

            /*
             * Métricas e monitoramento
             */
            "/actuator/**",

            /*
             * Configurações críticas
             */
            "/system/**",

            /*
             * Logs internos
             */
            "/logs/**"
    };
}
