package com.softserve.edu.oms.dao;

import com.softserve.edu.oms.entity.RoleDB;
import com.softserve.edu.oms.entity.RoleDB.RoleDBQueries;

public final class RoleDao extends ADao<RoleDB> {
    private static volatile RoleDao instance = null;

    private RoleDao() {
        super();
        init();
    }

    public static RoleDao get() {
        if (instance == null) {
            synchronized (RoleDao.class) {
                if (instance == null) {
                    instance = new RoleDao();
                }
            }
        }
        return instance;
    }

    private void init() {
        for (RoleDBQueries roleDBQueries : RoleDBQueries.values()) {
            sqlQueries.put(roleDBQueries.name(), roleDBQueries);
        }
     }

    protected RoleDB createInstance(String[] args) {
        return new RoleDB(Long.parseLong(args[0]), args[1]);
    }

    protected String[] getFields(RoleDB entity) {
        String[] fields = new String[1];
        fields[0]=entity.getRoleName();
         return fields;
    }

}
