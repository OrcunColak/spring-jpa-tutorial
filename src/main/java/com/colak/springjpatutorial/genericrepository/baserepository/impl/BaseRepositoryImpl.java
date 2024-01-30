package com.colak.springjpatutorial.genericrepository.baserepository.impl;

import com.colak.springjpatutorial.genericrepository.baserepository.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class  BaseRepositoryImpl<T, ID> implements BaseRepository<T, ID> {

    @PersistenceContext
    private EntityManager entityManager;
    private final Class<T> entityClass;

    protected BaseRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    @Transactional
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(T entity, ID id) {
        T result = entityManager.find((Class<T>) entity.getClass(), id);
        if (result != null) {
            entityManager.merge(result);
        }

    }

    @Override
    @Transactional
    public List<T> findAll() {
        return entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
    }

    @Override
    @Transactional
    public T findById(ID id) {
        return entityManager.find(entityClass, id);
    }
}
