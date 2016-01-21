package com.softserve.edu.atqc.tools;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ControlSearch {
    public static final String ERROR_LOAD_FAILED = "Web Page Load Failed";
    private static volatile ControlSearch instance = null;
    //private List<IObserveLoad> observeLoad; 
    private ASearchContext context;

    private ControlSearch() {
        //this.observeLoad = new ArrayList<IObserveLoad>();
        this.context = ContextRepository.get().getSearchExplicit();
    }

    public static ControlSearch get() {
        if (instance == null) {
            synchronized (ControlSearch.class) {
                if (instance == null) {
                    instance = new ControlSearch();
                }
            }
        }
        return instance;
    }

    // Set Strategy.
    ControlSearch setContext(ASearchContext context) {
        synchronized (ControlSearch.class) {
            this.context = context;
        }
        return this;
    }

    public ControlSearch setImplicitStrategy() {
        return setContext(ContextRepository.get().getSearchImplicit());
    }

    public ControlSearch setExplicitStrategy() {
        return setContext(ContextRepository.get().getSearchExplicit());
    }

    /**
     * An expectation for checking that an element is present on the DOM of a
     * page and visible.
     */
    WebElement getVisibleWebElement(ControlLocation controlLocation) {
        return context.getVisibleWebElement(controlLocation);
    }

    /**
     * An expectation for checking that all elements present on the web page
     * that match the locator are visible.
     */
    List<WebElement> getVisibleWebElements(ControlLocation controlLocation) {
        return context.getVisibleWebElements(controlLocation);
    }

    /**
     * An expectation for checking that an element is present on the DOM of a
     * page. This does not necessarily mean that the element is visible.
     */
    WebElement getPresentWebElement(ControlLocation controlLocation) {
        return context.getPresentWebElement(controlLocation);
    }

    /**
     * An expectation for checking that an element is either invisible or not
     * present on the DOM.
     */
    public boolean isInvisibleWebElement(ControlLocation controlLocation) {
        return context.isInvisibleWebElement(controlLocation);
    }

    /**
     * An expectation for checking that an element with text is either invisible
     * or not present on the DOM.
     */
    public boolean isInvisibleWebElementWithText(ControlLocation controlLocation, String text) {
        return context.isInvisibleWebElementWithText(controlLocation, text);
    }

    public boolean isInvisibleWebElementById(String id) {
        return isInvisibleWebElement(ControlLocation.getById(id));
    }

    public boolean isInvisibleWebElementByPartialLinkText(String partialLinkText) {
        return isInvisibleWebElement(ControlLocation.getByPartialLinkText(partialLinkText));
    }

    /**
     * Wait until an element is no longer attached to the DOM.
     * Do not mix implicit and explicit waits.
     */
    public boolean isStatelessOfWebElement(ControlWrapper controlWrapper) {
        return context.isStatelessOfWebElement(controlWrapper);
    }

    //TODO +++ not public
    public Select getVisibleSelectWebElement(ControlLocation controlLocation) {
        return new Select(getVisibleWebElement(controlLocation));
    }

    Select getVisibleSelectWebElement(ControlWrapper controlWrapper) {
        return new Select(controlWrapper.getWebElement());
    }

    Select getPresentSelectWebElement(ControlLocation controlLocation) {
        return new Select(getPresentWebElement(controlLocation));
    }

    Select getPresentSelectWebElement(ControlWrapper controlWrapper) {
        return new Select(controlWrapper.getWebElement());
    }

    public boolean isVisibleTitle(String partialTitle) {
        return context.isVisibleTitle(partialTitle);
    }

    /*
    public void addLoadCompleteEvent(IObserveLoad observeLoad){
        this.observeLoad.add(observeLoad);
    }

    public void deleteLoadCompleteEvents(){
        this.observeLoad.clear();
    }
    */

    /*
    public boolean isLoadComplete() {
        int countLoadCompletePages = 0;
        long beginTime;
        for (IObserveLoad currentObserveLoad : this.observeLoad) {
            beginTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - beginTime < ONE_SECOND
                    * ImplicitWrapper.get().getImplicitlyWaitTimeout()) {
                if (currentObserveLoad.loadComplete()) {
                    countLoadCompletePages++;
                    break;
                }
                try {
                    Thread.sleep(ContextUtils.ONE_SECOND / 2);
                } catch (Exception e) {
                    throw new GeneralCustomException(String.format(ContextUtils.ERROR_LOAD_FAILED,
                            WebDriverUtils.get().getWebDriver().getCurrentUrl()));
                }
            }
        }
        // TODO MultiThread Correction
        if (countLoadCompletePages != this.observeLoad.size()) {
            throw new GeneralCustomException(
                    String.format(ContextUtils.ERROR_LOAD_FAILED, WebDriverUtils.get().getWebDriver().getCurrentUrl()));
        }
        return countLoadCompletePages == this.observeLoad.size();
    }
    */
    
}
