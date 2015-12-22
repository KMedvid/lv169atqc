package com.softserve.edu.oms.data;

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
                .setLogin("http://localhost:8080/OMS/login.htm")
                .setLogout("http://localhost:8080/OMS/logout.htm")
                .build();
    }
    
    public IUrls getSsuUrls() {
        return Urls.get()
                .setLogin("http://ssu-oms:8180/OMS/login.htm")
                .setLogout("http://ssu-oms:8180/OMS/logout.htm")
                .build();
    }

}
