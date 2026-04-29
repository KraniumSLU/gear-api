package com.kranium.project.gearapi.modules.motherclass.dtos;

import java.util.List;
//Classe para gerenciamento de mappers onde existiram dtos de Request e response
public interface GenericMapper <E,R,Q>{
    /*
    E = Entidade
    R = Response
    Q = Request
*/
    E toEntity(Q request);
    R toResponse(E entity);
    default List<R> toResponseList(List<E>entities){
        return entities.stream().map(this::toResponse).toList();
    }
}