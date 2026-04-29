package com.kranium.project.gearapi.modules.users.domain;


public enum Role {
    ADMIN("ADM"),
    USUARIO("USUARIO"),
    MANUTENCAO("MANUTENCAO"),
    VISITANTE("VISITANTE");
    private final String name;
    Role(String name){
        this.name=name;
    }
}
