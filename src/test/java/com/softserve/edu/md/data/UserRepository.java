package com.softserve.edu.md.data;

import java.util.List;

public final class UserRepository {

    private static volatile UserRepository instance = null;

    private UserRepository() {
    }

    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public IUser getAdminUser() {
        return User.get()
                .setFirstname("Джимі")
                .setLastname("Хендрікс")
                .setLogin("admin")
                .setPassword("password")
                .setEmail("vova@i.ua")
                .build();
    }


    public List<IUser> getExistUsersCVS() {
        return new UserUtils().getAllUsers();
    }

    public List<IUser> getExistUsersExcel() {
        return new UserUtils("/users.xlsx", new ExcelUtils()).getAllUsers();
    }

}
