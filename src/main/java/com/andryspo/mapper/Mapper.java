package com.andryspo.mapper;

public interface Mapper<E, D> {

    E mapToEntity(D d);

    D mapToDto(E e);

}
