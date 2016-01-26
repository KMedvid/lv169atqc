package com.softserve.edu.md.data;

import java.util.List;

public final class UserRepository {

    private static volatile UserRepository instance = null;

    private UserRepository() {
    }

    public static UserRepository get() {
        if (instance == null) {
            synchronized(UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public IUser getCalibratorUser() {
        return User.get()
        		.setFirstname("Курт")
        		.setLastname("Кобейн")
        		.setLogin("calibrator-lv")
        		.setPassword("pass")
        		.setEmail("volodymyrignatiev@gmail.com")
        		.build();
    }

    public  IUser getInvalidUser() {
        return User.get()
        		.setFirstname("Курт")
        		.setLastname("Кобейн")
        		.setLogin("calibrator-lv")
        		.setPassword("pass11")
        		.setEmail("volodymyrignatiev@gmail.com")
        		.build();
    }
    public List<IUser> getExistUsersCVS() {
        return new CSVUsers().getAllUsers();
    }
}

  
