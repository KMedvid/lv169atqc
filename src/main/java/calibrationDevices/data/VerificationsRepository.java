package calibrationDevices.data;

public class VerificationsRepository {

    private static volatile VerificationsRepository instance = null;

    private VerificationsRepository() {
    }

    public static VerificationsRepository get() {
        if (instance == null) {
            synchronized (VerificationsRepository.class) {
                if (instance == null) {
                    instance = new VerificationsRepository();
                }
            }
        }
        return instance;
    }

    public IVerifications getVerification() {
        return Verifications.get()
                .setFirstname("Джеф")
                .setLastname("Rocker")
                .setMiddlename("West")
                .setEmail("mail@gmail.com")
                .setPhone("678554632")
                .setRegion("Львівська") 
                .setDistrict("Львів")
                .setLocality("Львів")
                .setIndex("79000")
                .setStreetType("Вулиця")
                .setStreetName("Личаківська")
                .setBuilding("3")
                .setFlat("1")
                .setCounterAmount("1")
                .setCounterType("Холодна вода")
                .setChooseProvider("ЛКП «Львівводоканал»")
                .setVerificationID("")
                .build();
    }
}