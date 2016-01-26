package calibrationDevices.data;

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

    public IUser getProviderUser() {
        
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
    
    public IUser getProviderGeneralUser() {
        
        return User.get()
                
                .setFirstname("Джеф Бек")
                .setLastname("Rocker")
                .setMiddlename("West")
                .setLogin("provider-lv")
                .setPassword("pass")
                .setEmail("mail@gmail.com")
                .setPhone("")
                .setExtraPhone("")
                .build();
    }

    public IUser getInvalidUser() {
        
        return User.get()

                .setFirstname("Джеffфa Бек")
                .setLastname("Rockeffr")
                .setMiddlename("Wesfft")
                .setLogin("provffider-lv")
                .setPassword("pffass")
                .setEmail("mail@ffgmail.com")
                .setPhone("")
                .setExtraPhone("")
                .build();
    }

    public IUser getExistUser() {
        
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
    
    public IUser getNewWorker() {
        
        return User.get()

                .setFirstname("Merlin")
                .setLastname("Manson")
                .setMiddlename("West")
                .setLogin("etllodd")
                .setPassword("pass")
                .setEmail("mail@gmail.com")
                .setPhone("222345678")
                .setExtraPhone("")
                .build();
    }
    public IUser getProviderWorker() {
        
        return User.get()

                .setFirstname("Ронні")
                .setLastname("Джонні")
                .setMiddlename("West")
                .setLogin("djhonni")
                .setPassword("pass")
                .setEmail("mail@gmail.com")
                .setPhone("882223345")
                .setExtraPhone("")
                .build();
    } 
    public IUser getEditedProviderWorker() {

        return User.get()

                .setFirstname("Рон")
                .setLastname("Джеф")
                .setMiddlename("West")
                .setLogin("djhonni")
                .setPassword("pass")
                .setEmail("mail@gmail.com")
                .setPhone("882223347")
                .setExtraPhone("")
                .build();
    }

}
