package com.softserve.edu.oms.services;

import com.softserve.edu.oms.dao.RoleDao;

public class RoleService {
    private static volatile RoleService instance = null;

    private RoleService() {
    }

    public static RoleService get() {
        if (instance == null) {
            synchronized (RoleService.class) {
                if (instance == null) {
                    instance = new RoleService();
                }
            }
        }
        return instance;
    }

    // Read
    public String getRoleNameById(long id) {
        return RoleDao.get().getById(id).getRoleName();
    }

    public Long getRoleIdByName(String roleName) {
        return RoleDao.get().getRoleIdByName(roleName).getId();
    }

}
