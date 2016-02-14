package com.softserve.edu.oms.data;

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
                .setFirstname("Roman")
                .setLastname("Kovalchuk")
                .setLogin("roman")
                .setPassword("qwerty")
                .setEmail("roman@gmail.com")
                .setRegion("West")
                .setRole("Administrator")
                .build();
    }

    public IUser getCustomerUser() {
        // return new User("firstName1", "lastName1", "login1", "qwerty",
        // "mail@gmail.com", "East", "Customer");
        return User.get()
                .setFirstname("firstName")
                .setLastname("lastName")
                .setLogin("login")
                //.setLogin("login1")
                .setPassword("qwerty")
                .setEmail("mail@gmail.com")
                .setRegion("East")
                .setRole("Customer")
                .build();
    }

    public IUser getInvalidUser() {
        // return new User("ivanka", "horoshko", "iva1", "qwerty1",
        // "mail@gmail.com", "West", "Administrator");
        return User.get()
                .setFirstname("ivanka")
                .setLastname("horoshko")
                .setLogin("iva1")
                .setPassword("qwerty1")
                .setEmail("mail@gmail.com")
                .setRegion("West")
                .setRole("Administrator")
                .build();
    }

    public IUser getExistUser() {
        return User.get()
                .setFirstname("myroslav")
                .setLastname("shram")
                .setLogin("myroslav")
                .setPassword("qwerty")
                .setEmail("mail@gmail.com")
                .setRegion("South")
                .setRole("Administrator")
                .build();
    }

    public IUser getNewUser() {
        return User.get()
                .setFirstname("newuser")
                .setLastname("newuser")
                .setLogin("newuser")
                .setPassword("qwerty")
                .setEmail("newuser@gmail.com")
                .setRegion("East")
                .setRole("Customer")
                .build();
    }
    
    public IUser getDelUser() {
        return User.get()
                .setFirstname("deluser")
                .setLastname("deluser")
                .setLogin("deluser")
                .setPassword("qwerty")
                .setEmail("deluser@gmail.com")
                .setRegion("East")
                .setRole("Customer")
                .build();
    }

    public List<IUser> getExistUsersCVS() {
        return new UserUtils().getAllUsers();
    }

    public List<IUser> getExistUsersExcel() {
        return new UserUtils("/users.xlsx", new ExcelUtils()).getAllUsers();
    }

}
