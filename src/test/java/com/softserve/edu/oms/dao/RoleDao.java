package com.softserve.edu.oms.dao;

import java.util.List;

import com.softserve.edu.oms.entity.RoleDB;

public class RoleDao implements IDao<RoleDB> {

    // Create
    public boolean insert(RoleDB entity) {
        return true;
    }

    // Read
    public RoleDB getById(Long id) {
        return null;
    }

    public RoleDB getByFieldName(String fieldName, String text) {
        return null;
    }

    public List<RoleDB> getAll() {
        return null;
    }

    // Update
    public boolean update(RoleDB entity) {
        return true;
    }

    // Delete
    public boolean deleteById(Long id) {
        return true;
    }

    public boolean delete(RoleDB entity) {
        return true;
    }

}
