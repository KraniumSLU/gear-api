package com.kranium.project.gearapi.modules.routes;

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
