package com.softserve.edu.oms.data;

public final class UserRepositoryStatic {
    
    private UserRepositoryStatic(){}

    public static IUser getAdminUser() {
        // TODO Code
        //return new User("ivanka", "horoshko", "iva", "qwerty", "mail@gmail.com", "West", "Administrator");
        return User.get()
                .setFirstname("ivanka")
                .setLastname("horoshko")
                .setLogin("iva")
                .setPassword("qwerty")
                .setEmail("mail@gmail.com")
                .setRegion("West")
                .setRole("Administrator")
                .build();
    }

    public static IUser getCustomerUser() {
        // TODO Code
        //return new User("firstName1", "lastName1", "login1", "qwerty", "mail@gmail.com", "East", "Customer");
        return User.get()
                .setFirstname("firstName1")
                .setLastname("lastName1")
                .setLogin("login1")
                .setPassword("qwerty")
                .setEmail("mail@gmail.com")
                .setRegion("East")
                .setRole("Customer")
                .build();
    }

    public static IUser getInvalidUser() {
        //return new User("ivanka", "horoshko", "iva1", "qwerty1", "mail@gmail.com", "West", "Administrator");
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

}
