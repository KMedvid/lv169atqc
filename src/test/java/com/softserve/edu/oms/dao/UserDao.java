package com.softserve.edu.oms.dao;

import com.softserve.edu.oms.entity.UserDB;
import com.softserve.edu.oms.entity.UserDB.UserDBQueries;

public final class UserDao extends ADao<UserDB> {
    private static volatile UserDao instance = null;

    private UserDao() {
        super();
        init();
    }

    public static UserDao get() {
        if (instance == null) {
            synchronized (UserDao.class) {
                if (instance == null) {
                    instance = new UserDao();
                }
            }
        }
        return instance;
    }

    private void init() {
       for (UserDBQueries userDBQueries : UserDBQueries.values()) {
           sqlQueries.put(userDBQueries.name(), userDBQueries);
       }
    }

    protected UserDB createInstance(String[] args) {
        return new UserDB(Long.parseLong(args[0] == null ? "0" : args[0]),
                Long.parseLong(args[1] == null ? "0" : args[0]),
                Double.parseDouble(args[2] == null ? "0" : args[2]),
                args[3], args[4], args[5], args[6], args[7],
                Long.parseLong(args[8] == null ? "0" : args[8]),
                Long.parseLong(args[9] == null ? "0" : args[9]),
                Long.parseLong(args[10] == null ? "0" : args[10]));
    }

    protected String[] getFields(UserDB entity) {
        String[] fields = new String[10];
        fields[0]=entity.getIsUserActive().toString();
        fields[1]=entity.getBalance().toString();
        fields[2]=entity.getEmail();
        fields[3]=entity.getFirstname();
        fields[4]=entity.getLastname();
        fields[5]=entity.getLogin();
        fields[6]=entity.getPassword();
        fields[7]=entity.getCustomerTypeRef().toString();
        fields[8]=entity.getRegionRef().toString();
        fields[9]=entity.getRoleRef().toString();
        return fields;
    }

    public UserDB getUserDBByLogin(String login) {
    	for (UserDB userDB : getByFieldName("Login", login)) {
    		System.out.println("ID = " + userDB.getId()+"  IsUserActive="+ userDB.getIsUserActive());
    	}
    	return getByFieldName("Login", login).get(0);
    }
    
}
