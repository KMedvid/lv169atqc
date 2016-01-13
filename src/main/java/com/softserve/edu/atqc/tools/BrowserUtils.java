package com.softserve.edu.atqc.tools;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.softserve.edu.atqc.data.StartData;

public final class BrowserUtils {
    private static volatile BrowserUtils instance = null;
    private final HashMap<Long, StartData> startDatas;

    private BrowserUtils() {
        this.startDatas = new HashMap<Long, StartData>();
    }

    public static BrowserUtils get() {
        return get(null);
    }

    public static BrowserUtils get(StartData startData) {
        if (instance == null) {
            synchronized (BrowserUtils.class) {
                if (instance == null) {
                    instance = new BrowserUtils();
                }
            }
        }
        if (instance != null) {
            if (startData == null) {
                if (instance.getStartData() == null) {
                    instance.setStartData(new StartData());
                }
                if ((instance.getStartData().getBrowser() == null)
                        || (!instance.getBrowser().isEnabled())) {
                    instance.startupBrowser(instance.getStartData());
                }
            } else {
                // startData != null
                if (instance.getStartData() == null) {
                    instance.setStartData(startData);
                }
                if ((instance.getStartData().getBrowser() != null)
                        && (instance.getBrowser().isEnabled())
                        && (!instance.getStartData().getBrowserName().equals(startData.getBrowserName()))) {
                    instance.getBrowser().close();
                    // instance.getBrowser().quit();
                    instance.setStartData(startData);
                }
                if ((instance.getStartData().getBrowser() == null)
                        || !instance.getBrowser().isEnabled()) {
                    instance.startupBrowser(instance.getStartData());
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

    private List<String> getAccessableBrowsers() {
        List<String> result = new ArrayList<String>();
        for (Method method : BrowserRepository.class.getDeclaredMethods()) {
            if (Modifier.isPublic(method.getModifiers())) {
                result.add(method.getName());
            }
        }
        return result;
    }
    
    private boolean isAccessableBrowsersPath(String browserName) {
        return true;
    }
    
    private void startupBrowser(StartData startData) {
        String browserName = "getDefaultBrowser";
        for (String methodName : getAccessableBrowsers()) {
            if (methodName.contains(startData.getBrowserName())) {
                browserName = methodName;
                break;
            }
        }
        if ((startData.getBrowserPath() != null) 
                && (startData.getBrowserPath().length() > 0 )
                && (isAccessableBrowsersPath(browserName))) {
            //
        }
        //Method method = BrowserRepository.class.getMethod(browserName);
        //ABrowser firefox = (ABrowser)method.invoke(browserRepository);
    }

    public ABrowser getBrowser() {
        return startDatas.get(Thread.currentThread().getId()).getBrowser();
    }

}
