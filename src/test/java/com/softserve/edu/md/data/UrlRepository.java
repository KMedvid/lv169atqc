package com.softserve.edu.md.data;

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
                .setLogin("http://localhost:8080/#/login")
                .setLogout("http://localhost:8080/#/logout")
                .build();
    }
  
    public IUrls getVmUrls() {
        return Urls.get()
                .setLogin("http://10.1.10.100:8080/#/start")
                .setLogout("http://10.1.10.100:8080/#/logout")
                .build();
    }
    
    public IUrls getTrainingLocalUrls() {
        return Urls.get()
                .setLogin("http://java.training.local:8080/#/login")
                .setLogout("http://java.training.local:8080/#/logout")
                .build();
    }

}
