package com.softserve.edu.atqc.tools;

import java.util.HashMap;

import com.softserve.edu.atqc.data.StartData;

public final class BrowserUtils {
    private static volatile BrowserUtils instance = null;
    private final HashMap<Long, StartData> startDatas;

    private BrowserUtils() {
        this.startDatas = new HashMap<Long, StartData>();
    }

//    public static BrowserUtils get() {
//        System.out.println("WebDriverUtils_get()");
//        return get(BrowserRepository.getDefault());
//    }

    public static BrowserUtils get(StartData startData) {
        if (instance == null) {
            synchronized (BrowserUtils.class) {
                if (instance == null) {
                    instance = new BrowserUtils();
                }
            }
        }
        if (instance != null) {
            synchronized (BrowserUtils.class) {
                if ((startData.getBrowser() == null)
                        && ((instance.getStartData() == null) || !instance.getBrowser().isEnabled())) {
                    // Create Browser
                    //browser = BrowserRepository.getFirefoxByTemporaryProfile();
                }
                if ((startData.getBrowser() != null) 
                        && (instance.getStartData() != null)
                        && instance.getBrowser().isEnabled()
                        && (!instance.getBrowser().getWebDriverName().equals(startData.getBrowser().getWebDriverName()))
                        && (!instance.getStartData().getBrowserName().equals(startData.getBrowserName()))) {
                    instance.getBrowser().close();
                }
                if ( (instance.getStartData() != null)
                        && ((instance.getBrowser() == null)
                                || ((startData != null)
                                        && (!instance.getBrowser().getWebDriverName().equals(startData.getBrowser().getWebDriverName())))
                                || (!instance.getBrowser().isEnabled()))){
                    System.out.println("Create browser  " + "\tThread ID= " + Thread.currentThread().getId());
                    // Browser
                    instance.setStartData(startData);
                }
            }
        }
        return instance;
    }

    public static void quitAll() {
        if (instance != null) {
            // for (Long threadId : instance.browsers.keySet()) {
            for (StartData startData : instance.startDatas.values()) {
                startData.getBrowser().quit();
            }
        }
    }

    private void setStartData(StartData startData) {
        this.startDatas.put(Thread.currentThread().getId(), startData);
    }

    private StartData getStartData() {
        return startDatas.get(Thread.currentThread().getId());
    }

    public ABrowser getBrowser() {
        return startDatas.get(Thread.currentThread().getId()).getBrowser();
    }

}
