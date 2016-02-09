package com.softserve.edu.oms.services;

import com.softserve.edu.oms.dao.UserDao;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.ServiceUtils;
import com.softserve.edu.oms.entity.UserDB;

public class UserService {
    private static volatile UserService instance = null;

    private UserService() {
    }

    public static UserService get() {
        if (instance == null) {
            synchronized (UserService.class) {
                if (instance == null) {
                    instance = new UserService();
                }
            }
        }
        return instance;
    }

	// Create
	public boolean insertUser(IUser user) {
		return UserDao.get().insert(ServiceUtils.get().user2UserDB(user));
	}
    
    // Read
    public IUser getUserByLogin(String login) {
        UserDB userDB = UserDao.get().getUserDBByLogin(login);
        return ServiceUtils.get().userDB2IUser(userDB,
        		RoleService.get().getRoleNameById(userDB.getRoleRef()));
    }

    public String getUserFirstnameByLogin(String login) {
        return UserDao.get().getUserDBByLogin(login).getFirstname();
    }

    // Delete
    public boolean deleteUsersByLogin(String login) {
        return UserDao.get().delete(UserDao.get().getUserDBByLogin(login));  
    }

}
