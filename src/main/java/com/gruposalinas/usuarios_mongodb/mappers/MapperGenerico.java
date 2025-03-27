package com.gruposalinas.usuarios_mongodb.mappers;

import org.modelmapper.ModelMapper;

public class MapperGenerico {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static <T, D> D mapEntity(T entity, Class<D> dtoClass) {
        return MAPPER.map(entity, dtoClass);
    }
}
