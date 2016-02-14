package com.softserve.edu.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.softserve.edu.exceptions.GeneralCustomException;

public class PageObserveLoad {
    public static final String ERROR_LOAD_FAILED = "Web Page Load Failed. Url is %s";
    private static volatile PageObserveLoad instance = null;
    private final HashMap<Long, List<IObserveLoad>> observeLoad;

    private PageObserveLoad() {
        this.observeLoad = new HashMap<Long, List<IObserveLoad>>(); 
    }

    public static PageObserveLoad get() {
        if (instance == null) {
            synchronized (ControlSearch.class) {
                if (instance == null) {
                    instance = new PageObserveLoad();
                }
            }
        }
        return instance;
    }

    private List<IObserveLoad> getCurrentEvents() {
        List<IObserveLoad> currentEvents = this.observeLoad.get(Thread.currentThread().getId());
        if (currentEvents == null) {
            currentEvents = new ArrayList<IObserveLoad>();
            this.observeLoad.put(Thread.currentThread().getId(), currentEvents);
        }
        return currentEvents;
    }

    public void addLoadCompleteEvent(IObserveLoad observeLoad){
        getCurrentEvents().add(observeLoad);
    }

    public void deleteLoadCompleteEvents(){
        getCurrentEvents().clear();
    }

    public boolean isLoadComplete() {
        int countLoadCompletePages = 0;
        long beginTime;
        for (IObserveLoad currentObserveLoad : getCurrentEvents()) {
            beginTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - beginTime < ASearchContext.ONE_SECOND
                    * SearchExplicit.get().getExplicitlyWaitTimeout()) {
                if (currentObserveLoad.loadComplete()) {
                    countLoadCompletePages++;
                    break;
                }
                try {
                    Thread.sleep(ASearchContext.ONE_SECOND / 2);
                } catch (Exception e) {
                    throw new GeneralCustomException(String.format(PageObserveLoad.ERROR_LOAD_FAILED,
                            BrowserUtils.get().getBrowser().getWebDriver().getCurrentUrl()));
                }
            }
        }
        if (countLoadCompletePages !=  getCurrentEvents().size()) {
            throw new GeneralCustomException(String.format(PageObserveLoad.ERROR_LOAD_FAILED,
                    BrowserUtils.get().getBrowser().getWebDriver().getCurrentUrl()));
        }
        return countLoadCompletePages == getCurrentEvents().size();
    }

}
