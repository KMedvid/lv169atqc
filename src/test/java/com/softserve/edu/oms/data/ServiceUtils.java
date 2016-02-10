package com.softserve.edu.oms.data;

import com.softserve.edu.oms.entity.UserDB;
import com.softserve.edu.oms.services.RoleService;

public class ServiceUtils {
    private static volatile ServiceUtils instance = null;

    private ServiceUtils() {
    }

    public static ServiceUtils get() {
        if (instance == null) {
            synchronized (ServiceUtils.class) {
                if (instance == null) {
                    instance = new ServiceUtils();
                }
            }
        }
        return instance;
    }

    // TODO Use RegionDao
    public IUser userDB2IUser(UserDB userDB, String roleName) {
        return User.get()
                .setFirstname(userDB.getFirstname())
                .setLastname(userDB.getLastname())
                .setLogin(userDB.getLogin())
                .setPassword(userDB.getPassword())
                .setEmail(userDB.getEmail())
                .setRegion("West")
                .setRole(roleName)
                .build();
    }

    // TODO
    public UserDB user2UserDB(IUser user) {
    	return new UserDB(0L, 1L, 0.0, user.getEmail(), user.getFirstname(), user.getLastname(),
    			user.getLogin(), user.getPassword(), 1L, 1L,
    			RoleService.get().getRoleIdByName(user.getRole()));
    }

}
