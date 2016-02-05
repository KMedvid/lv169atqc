package com.softserve.edu.oms.dao;

import java.util.List;

public interface IDao<TEntity> {

    // Create
    boolean insert(TEntity entity);

    // Read
    TEntity getById(Long id);

    TEntity getByFieldName(String fieldName, String text);

    // TEntity getByFieldName(String fieldName, Long value);

    List<TEntity> getAll();

    // Update
    boolean update(TEntity entity);

    // Delete
    boolean deleteById(Long id);

    boolean delete(TEntity entity);

}
