package com.softserve.edu.oms.dao;

import java.util.List;

import com.softserve.edu.oms.entity.IEntity;

public interface IDao<TEntity extends IEntity> {

    // Create
    boolean insert(TEntity entity);

    // Read
    TEntity getById(Long id);

    List<TEntity> getByFieldName(String fieldName, String text);

    // TEntity getByFieldName(String fieldName, Long value);

    List<TEntity> getAll();

    // Update
    boolean updateByFieldName(String fieldName, String text);

    // Delete
    boolean deleteById(Long id);

    boolean delete(TEntity entity);

}
