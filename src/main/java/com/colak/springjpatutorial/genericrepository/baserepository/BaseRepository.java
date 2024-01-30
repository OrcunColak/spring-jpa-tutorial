package com.colak.springjpatutorial.genericrepository.baserepository;

import java.util.List;

public interface BaseRepository<T, ID> {
    T save(T entity);

    void update(T entity, ID id);

    List<T> findAll();

    T findById(ID id);
}
