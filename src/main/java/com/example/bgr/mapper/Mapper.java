package com.example.bgr.mapper;

import java.util.List;
import java.util.Objects;

public abstract class Mapper<D, E> {

    public abstract D mapToDto(E entity);

    public abstract E mapToEntity(D dto);

    public List<D> mapToDtos(List<E> entities) {
        return entities.stream().filter(Objects::nonNull).map(this::mapToDto).toList();
    }

    public List<E> mapToEntites(List<D> dtos) {
        return dtos.stream().filter(Objects::nonNull).map(this::mapToEntity).toList();
    }
}
