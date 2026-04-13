package org.eduardomango.practicaspringweb.model.repositories;

import java.util.List;

public interface IRepository <T>{

    List<T> findAll();

    T save(T entity);

    void delete(T entity);

    void update(T entity);
}
