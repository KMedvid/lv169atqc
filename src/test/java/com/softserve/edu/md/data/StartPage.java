package com.softserve.edu.md.data;

import com.softserve.edu.atqc.data.StartData;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.md.pages.HomePage;

public class StartPage {
    private final String START_PAGE_UNDEFINED = "StartPage is Undefined.";
    private static volatile StartPage instance = null;
    
    private StartPage() {
    }

    public static StartPage get() {
        if (instance == null) {
            synchronized (StartPage.class) {
                if (instance == null) {
                    instance = new StartPage();
                }
            }
        }
        return instance;
    }

    // TODO Add Static
    
    public HomePage load() {
        StartData startData = BrowserUtils.get().getStartData();
        if ((startData.getLogin() == null)
                || (startData.getLogin().isEmpty())) {
            // TODO Create class Exception + log + report.
            throw new RuntimeException(START_PAGE_UNDEFINED);
        }
        return login(startData);
    }

    public HomePage load(StartData startData) {
        BrowserUtils.get(startData);
        return login(startData);
    }
   
    public HomePage login(StartData startData) {
        BrowserUtils.get().getBrowser().loadPage(startData.getLogout());
        BrowserUtils.get().getBrowser().loadPage(startData.getLogin());
        return new HomePage();
    }

    public HomePage logout(StartData startData) {
        BrowserUtils.get().getBrowser().loadPage(startData.getLogout());
        return new HomePage();
    }

    public void quit() {
        BrowserUtils.get().getBrowser().quit();
    }
    
    public void quitAll() {
        BrowserUtils.quitAll();
    }

    // TODO Add Observe
    //ControlSearch.get().addLoadCompleteEvent(new PageLoadComplete());

}
