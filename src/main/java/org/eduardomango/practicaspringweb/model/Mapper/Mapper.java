package org.eduardomango.practicaspringweb.model.Mapper;

public interface Mapper <T,U>{

    T toDTO (U u);
    U toEntity (T t);
}
