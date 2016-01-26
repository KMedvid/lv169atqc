package com.softserve.edu.md.data;

import com.softserve.edu.atqc.data.StartData;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.md.pages.LoginPage;

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
    
    public LoginPage load() {
        StartData startData = BrowserUtils.get().getStartData();
        if ((startData.getLogin() == null)
                || (startData.getLogin().isEmpty())) {
            // TODO Create class Exception + log + report.
            throw new RuntimeException(START_PAGE_UNDEFINED);
        }
        return login(startData);
    }

    public LoginPage load(StartData startData) {
        BrowserUtils.get(startData);
        return login(startData);
    }
   
    // TODO Code Duplicate
    public LoginPage login() {
        StartData startData = BrowserUtils.get().getStartData();
        if ((startData.getLogin() == null)
                || (startData.getLogin().isEmpty())) {
            // TODO Create class Exception + log + report.
            throw new RuntimeException(START_PAGE_UNDEFINED);
        }
        return login(startData);
    }
    
    public LoginPage login(StartData startData) {
        BrowserUtils.get().getBrowser().loadPage(startData.getLogout());
        BrowserUtils.get().getBrowser().loadPage(startData.getLogin());
        return new LoginPage();
    }

    // TODO Code Duplicate
    public LoginPage logout() {
        StartData startData = BrowserUtils.get().getStartData();
        if ((startData.getLogin() == null)
                || (startData.getLogin().isEmpty())) {
            // TODO Create class Exception + log + report.
            throw new RuntimeException(START_PAGE_UNDEFINED);
        }
        BrowserUtils.get().getBrowser().loadPage("http://java.training.local:8080/#/login");
        return logout(startData);
    }
    
    public LoginPage logout(StartData startData) {
        BrowserUtils.get().getBrowser().loadPage(startData.getLogout());
        BrowserUtils.get().getBrowser().loadPage("http://java.training.local:8080/#/login");
        return new LoginPage();
    }

    public void quit() {
        BrowserUtils.get().getBrowser().quit();
    }
    
    public void closeAll() {
        BrowserUtils.closeAll();
    }

    // TODO Add Observe
    //ControlSearch.get().addLoadCompleteEvent(new PageLoadComplete());

}
