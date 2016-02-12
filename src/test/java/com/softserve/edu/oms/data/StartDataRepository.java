package com.softserve.edu.oms.data;

import com.softserve.edu.atqc.data.StartData;

public final class StartDataRepository {

    private static volatile StartDataRepository instance = null;

    private StartDataRepository() {
    }

    public static StartDataRepository get() {
        if (instance == null) {
            synchronized (StartDataRepository.class) {
                if (instance == null) {
                    instance = new StartDataRepository();
                }
            }
        }
        return instance;
    }

    public StartData getCromeSsu() {
        return new StartData("http://ssu-oms:8180/OMS/login.htm",
                "http://ssu-oms:8180/OMS/logout.htm", "", "chrome", "");
    }
    
}
