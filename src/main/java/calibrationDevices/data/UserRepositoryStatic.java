package calibrationDevices.data;

public final class UserRepositoryStatic {
    
    private UserRepositoryStatic(){}

    public static IUser getProviderUser() {
        return User.get()

                .setFirstname("Джефa Бек")
                .setLastname("Rocker")
                .setMiddlename("West")
                .setLogin("provider-lv")
                .setPassword("pass")
                .setEmail("mail@gmail.com")
                .setPhone("")
                .setExtraPhone("")
                .build();
    }


    public static IUser getInvalidUser() {
        return User.get()
                .setFirstname("Дже")
                .setLastname("Rockjer")
                .setMiddlename("Welst")
                .setLogin("provilder-lv")
                .setPassword("pasllls")
                .setEmail("mail@gmail.com")
                .setPhone("")
                .setExtraPhone("")
                .build();

    }

}
