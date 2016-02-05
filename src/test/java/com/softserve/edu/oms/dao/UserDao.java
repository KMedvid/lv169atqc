package com.softserve.edu.oms.dao;

import java.util.List;

import com.softserve.edu.oms.entity.UserDB;

public class UserDao implements IDao<UserDB> {

    // Create
    public boolean insert(UserDB entity) {
        return true;
    }

    // Read
    public UserDB getById(Long id) {
        return null;
    }

    public UserDB getByFieldName(String fieldName, String text) {
        return null;
    }

    public List<UserDB> getAll() {
        return null;
    }

    // Update
    public boolean update(UserDB entity) {
        return true;
    }

    // Delete
    public boolean deleteById(Long id) {
        return true;
    }

    public boolean delete(UserDB entity) {
        return true;
    }

}
