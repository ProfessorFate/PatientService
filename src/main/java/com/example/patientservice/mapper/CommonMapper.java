package com.example.patientservice.mapper;

public interface CommonMapper<D,E> {

    D toDto(E e);

    E toEntity(D d);

    Iterable<D> toListDto(Iterable<E> entityList);

    Iterable<E> toListEntity(Iterable<D> dtoList);

}
