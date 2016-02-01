package com.softserve.edu.atqc.tools;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

class SearchImplicit extends ASearchContext {
    private static volatile SearchImplicit instance = null;
    private long implicitlyWaitTimeout = 10L;

    private SearchImplicit() {
    }

    public static SearchImplicit get() {
        if (instance == null) {
            synchronized (SearchImplicit.class) {
                if (instance == null) {
                    instance = new SearchImplicit();
                }
            }
        }
        BrowserUtils.get().getBrowser().getWebDriver()
            .manage().timeouts().implicitlyWait(instance.implicitlyWaitTimeout,TimeUnit.SECONDS);
        SearchExplicit.get().setExplicitlyWaitTimeout(0L);
        return instance;
    }

    void setImplicitlyWaitTimeout(long implicitlyWaitTimeout) {
        this.implicitlyWaitTimeout = implicitlyWaitTimeout;
        BrowserUtils.get().getBrowser().getWebDriver()
            .manage().timeouts().implicitlyWait(implicitlyWaitTimeout, TimeUnit.SECONDS);
    }

    long getImplicitlyWaitTimeout() {
        return this.implicitlyWaitTimeout;
    }

    WebElement getVisibleWebElement(ControlLocation controlLocation) {
    	BrowserUtils.get().getBrowser().getWebDriver()
        .manage().timeouts().implicitlyWait(implicitlyWaitTimeout, TimeUnit.SECONDS);
        WebElement result = BrowserUtils.get().getBrowser().getWebDriver()
                .findElement(controlLocation.getBy());
        if (!(result.isEnabled() )) {
            // TODO
            //throw new ScreenCapturingCustomException(String.format(ASearchControl.ERROR_NOT_FOUND, controlLocation.getValue()));
            throw new RuntimeException(String.format(ASearchContext.ERROR_NOT_FOUND, controlLocation.getValue()));
        }
        return result;
    }

    List<WebElement> getVisibleWebElements(ControlLocation controlLocation) {
        int countInvisibleWebElements = 0;
        List<WebElement> results = BrowserUtils.get().getBrowser().getWebDriver()
                .findElements(controlLocation.getBy());
        for (WebElement webElement : results) {
            if (!(webElement.isDisplayed())) {
                countInvisibleWebElements++;
            }
        }
        if (countInvisibleWebElements == results.size()) {
            //throw new ScreenCapturingCustomException(String.format(ASearchControl.ERROR_NOT_FOUND, controlLocation.getValue()));
            throw new RuntimeException(String.format(ASearchContext.ERROR_NOT_FOUND, controlLocation.getValue()));
        }
        return results;
    }

    WebElement getPresentWebElement(ControlLocation controlLocation) {
        return BrowserUtils.get().getBrowser().getWebDriver()
                .findElement(controlLocation.getBy());
    }

    boolean isInvisibleWebElement(ControlLocation controlLocation) {
        boolean isWebElementInvisible = false;
        long beginTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - beginTime < ASearchContext.ONE_SECOND * getImplicitlyWaitTimeout()) {
            try {
                BrowserUtils.get().getBrowser().getWebDriver()
                    .findElement(controlLocation.getBy());
                Thread.sleep(ASearchContext.ONE_SECOND / 2);
            } catch (NoSuchElementException e) {
                isWebElementInvisible = true;
                break;
            } catch (Exception e) {
//                throw new ScreenCapturingCustomException(
//                        String.format(ASearchControl.ERROR_STILL_VISIBLE, controlLocation.getValue()));
                throw new RuntimeException(String.format(ASearchContext.ERROR_STILL_VISIBLE, controlLocation.getValue()));
            }
        }
        return isWebElementInvisible;
    }

    boolean isInvisibleWebElementWithText(ControlLocation controlLocation, String text){
        // TODO +++++++++++++++++++++++++++++++++++++++++++++++
        boolean isWebElementInvisible = false;
        long beginTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - beginTime < ASearchContext.ONE_SECOND * getImplicitlyWaitTimeout()) {
            try {
                BrowserUtils.get().getBrowser().getWebDriver()
                    .findElement(controlLocation.getBy());
                Thread.sleep(ASearchContext.ONE_SECOND / 2);
            } catch (NoSuchElementException e) {
                isWebElementInvisible = true;
                break;
            } catch (Exception e) {
//                throw new ScreenCapturingCustomException(
//                        String.format(ASearchControl.ERROR_STILL_VISIBLE, controlLocation.getValue()));
                throw new RuntimeException(String.format(ASearchContext.ERROR_STILL_VISIBLE, controlLocation.getValue()));
            }
        }
        return isWebElementInvisible;
    }

    boolean isStatelessOfWebElement(ControlWrapper controlWrapper) {
        boolean isStalenessWebElement = false;
        long beginTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - beginTime < ASearchContext.ONE_SECOND * getImplicitlyWaitTimeout()) {
            try {
                controlWrapper.isDisplayed();
                Thread.sleep(ASearchContext.ONE_SECOND / 2);
            } catch (StaleElementReferenceException e) {
                isStalenessWebElement = true;
                break;
            } catch (Exception e) {
//                throw new ScreenCapturingCustomException(String.format(ASearchControl.ERROR_STILL_VISIBLE,
//                        webElementWrapper.getWebElement().getTagName()));
                throw new RuntimeException(String.format(ASearchContext.ERROR_STILL_VISIBLE,
                        controlWrapper.getWebElement().getTagName()));
            }
        }
        return isStalenessWebElement;
    }
    
    boolean isVisibleTitle(String partialTitle) {
        boolean isVisibleTitlePage = false;
        long beginTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - beginTime < ASearchContext.ONE_SECOND * getImplicitlyWaitTimeout()) {
            if (BrowserUtils.get().getBrowser().getWebDriver()
                    .getTitle().toLowerCase().contains(partialTitle.toLowerCase())) {
                isVisibleTitlePage = true;
                break;
            }
            try {
                Thread.sleep(ASearchContext.ONE_SECOND / 2);
            } catch (Exception e) {
//                throw new ScreenCapturingCustomException(
//                        String.format(ASearchControl.ERROR_TITLE_INVISIBLE, partialTitle));
                throw new RuntimeException(String.format(ASearchContext.ERROR_TITLE_INVISIBLE, partialTitle));
            }
        }
        return isVisibleTitlePage;
    }

}
