package calibrationDevices.data;

public final class UrlRepository {
    private static volatile UrlRepository instance = null;

    private UrlRepository() {
    }

    public static UrlRepository get() {
        if (instance == null) {
            synchronized (UrlRepository.class) {
                if (instance == null) {
                    instance = new UrlRepository();
                }
            }
        }
        return instance;
    }

    public IUrls getLocalUrls() {
        return Urls.get()
                .setLogin("http://localhost:9090/#/login")
                .setLogout("http://localhost:9090/#/login")
                .build();
    }
    
    public IUrls getSoftServeUrls() {
        return Urls.get()
                .setLogin("http://java.training.local:8080/#/login")
                .setLogout("http://java.training.local:8080/#/login/")
                .build();
    }
    public IUrls getStartLocalUrls() {
        return Urls.get()
                .setLogin("http://localhost:9090/#/start")
                .setLogout("http://localhost:9090/#/start")
                .build();
    }
}