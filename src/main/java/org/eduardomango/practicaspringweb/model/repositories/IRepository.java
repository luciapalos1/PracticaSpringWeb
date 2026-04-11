package org.eduardomango.practicaspringweb.model.repositories;

import java.util.List;

public interface IRepository <T>{

    List<T> findAll();

    T save(T ntitey);

    void delete(T entity);

    void update(T entity);
}
