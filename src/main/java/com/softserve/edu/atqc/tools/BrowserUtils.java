package com.softserve.edu.atqc.tools;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.softserve.edu.atqc.data.StartData;

public final class BrowserUtils {
    private final String NO_SUCH_METHOD = "No such method.";
    private final String DEFAULT_BROWSER = "getDefaultBrowser";
    private final String EXPLICIT = "explicit";
    private final String IMPLICIT = "implicit";
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
                if (startData != null) {
                System.out.println("*****startData.getBrowserName()="
                        +startData.getBrowserName());}
                if (instance.getStartData() != null) {
                System.out.println("*****instance.getStartData().getBrowserName()="
                        +instance.getStartData().getBrowserName());}
                if (instance.getStartData() == null) {
                    instance.setStartData(startData);
                }
                System.out.println("++++startData.getBrowserName()="
                        +startData.getBrowserName());
                System.out.println("++++instance.getStartData().getBrowserName()="
                        +instance.getStartData().getBrowserName());
                
                System.out.println("\t(instance.getStartData().getBrowser() != null)"
                        +(instance.getStartData().getBrowser() != null));
                if (instance.getStartData().getBrowser() != null) {
                System.out.println("\t(instance.getBrowser().isEnabled())"
                        +(instance.getBrowser().isEnabled())); }
                System.out.println("\t(!instance.getStartData().getBrowserName().equals(startData.getBrowserName()))"
                        +(!instance.getStartData().getBrowserName().equals(startData.getBrowserName())));
                
                if ((instance.getStartData().getBrowser() != null)
                        && (instance.getBrowser().isEnabled())
                        && (!instance.getStartData().getBrowserName().equals(startData.getBrowserName()))) {
                    System.out.println("++++instance.getBrowser().close();");
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
        this.startDatas.put(Thread.currentThread().getId(), startData.clone());
    }

    private StartData getStartData() {
        return startDatas.get(Thread.currentThread().getId());
    }

    private List<String> getAccessableBrowsers() {
        List<String> result = new ArrayList<String>();
        for (Method method : BrowserRepository.class.getDeclaredMethods()) {
            if ((Modifier.isPublic(method.getModifiers())) 
                    && (!Modifier.isStatic(method.getModifiers()))) {
                result.add(method.getName());
            }
        }
        return result;
    }
    
    private boolean isAccessableBrowsersPath(String browserName) {
        boolean result = false;
        for (Method method : BrowserRepository.class.getDeclaredMethods()) {
            if ((Modifier.isPublic(method.getModifiers())) 
                    && (!Modifier.isStatic(method.getModifiers()))
                    && (method.getParameters().length == 1) 
                    && (method.getName().equals(browserName))
                    && (method.getParameters()[0].getType().getName().equals(String.class.getName()))) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    private void startupBrowser(StartData startData) {
        String browserName = DEFAULT_BROWSER;
        Method method;
        for (String methodName : getAccessableBrowsers()) {
            if (methodName.toLowerCase().contains(startData.getBrowserName().toLowerCase())) {
                browserName = methodName;
                break;
            }
        }
        if ((startData.getBrowserPath() != null)
                && (startData.getBrowserPath().length() > 0)
                && (isAccessableBrowsersPath(browserName))) {
            try {
               method = BrowserRepository.class.getMethod(browserName, String.class);
               startData.setBrowser((ABrowser) method.invoke(BrowserRepository.get(),
                       new Object[] { startData.getBrowserPath() }));
            } catch (Exception e) {
                // TODO Create class Exception + log + report.
                throw new RuntimeException(NO_SUCH_METHOD, e);
            }
        } else {
            try {
                method = BrowserRepository.class.getMethod(browserName);
                startData.setBrowser((ABrowser) method.invoke(BrowserRepository.get()));
             } catch (Exception e) {
                 // TODO Create class Exception + log + report.
                 throw new RuntimeException(NO_SUCH_METHOD, e);
             }
        }
        // Set Search Strategy
        setSearchStrategy(startData);
    }

    private void setSearchStrategy(StartData startData) {
        if ((startData.getSearchStrategy() != null) 
                && (startData.getSearchStrategy().length() > 0)) {
            if (startData.getSearchStrategy().toLowerCase().contains(EXPLICIT)) {
                //ControlSearch.get().setExplicitStrategy();
                ControlSearch.get().setContext(ContextRepository.get().getSearchExplicit());
            } else if (startData.getSearchStrategy().toLowerCase().contains(IMPLICIT)) {
                //ControlSearch.get().setImplicitStrategy();
                ControlSearch.get().setContext(ContextRepository.get().getSearchImplicit());
            } else {
                ControlSearch.get().setContext(ContextRepository.get().getSearchDefault());
            }
        } else {
            ControlSearch.get().setContext(ContextRepository.get().getSearchDefault());
        }
    }
    
    public ABrowser getBrowser() {
        return startDatas.get(Thread.currentThread().getId()).getBrowser();
    }

}
