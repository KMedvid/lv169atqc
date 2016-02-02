package com.softserve.edu.atqc.tools;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.exceptions.ScreenCapturingCustomException;

class SearchImplicit extends ASearchContext {
    private static volatile SearchImplicit instance = null;
    private long implicitlyWaitTimeout = 10L; // 30L;

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
        // TODO Set Implicit Wait for PageLoad and Script
//        BrowserUtils.get().getBrowser().getWebDriver()
//            .manage().timeouts().pageLoadTimeout(instance.implicitlyWaitTimeout,TimeUnit.SECONDS);
//        BrowserUtils.get().getBrowser().getWebDriver()
//            .manage().timeouts().setScriptTimeout(instance.implicitlyWaitTimeout,TimeUnit.SECONDS);
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
        WebElement result = null;
        long beginTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - beginTime < ASearchContext.ONE_SECOND * getImplicitlyWaitTimeout()) {
            try {
                result = BrowserUtils.get().getBrowser().getWebDriver()
                        .findElement(controlLocation.getBy());
                if ((result != null) 
                        && (result.isDisplayed())) {
                    break;
                }
                Thread.sleep(ASearchContext.ONE_SECOND / 2);
            } catch (NoSuchElementException e) {
                throw new ScreenCapturingCustomException(String.format(ASearchContext.ERROR_NOT_FOUND,
                        controlLocation.getValue()));
                //throw new RuntimeException(String.format(ASearchContext.ERROR_NOT_FOUND,
                //controlLocation.getValue()));
            } catch (Exception e) {
                throw new ScreenCapturingCustomException(ASearchContext.ERROR_BY_SEARCH, e);
            }
        }
        System.out.println("\t**********Web Element " + result.getTagName() + "  text " + result.getText()
                + "  result.isDisplayed() = " + result.isDisplayed()
                + "  result.isEnabled() = " + result.isEnabled()
                + "  result.isSelected() = " + result.isSelected());
        if ((result == null)
                || (!(result.isDisplayed()))) {
            System.out.println("\t*************throw new ScreenCapturingCustomException");
            // TODO Code Duplicate
            throw new ScreenCapturingCustomException(String.format(ASearchContext.ERROR_NOT_FOUND,
                    controlLocation.getValue()));
            //throw new RuntimeException(String.format(ASearchContext.ERROR_NOT_FOUND,
            //controlLocation.getValue()));
        }
        return result;
    }

    // TODO getPresentElements
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
            throw new ScreenCapturingCustomException(String.format(ASearchContext.ERROR_NOT_FOUND, controlLocation.getValue()));
            //throw new RuntimeException(String.format(ASearchContext.ERROR_NOT_FOUND, controlLocation.getValue()));
        }
        return results;
    }

    WebElement getPresentWebElement(ControlLocation controlLocation) {
        return BrowserUtils.get().getBrowser().getWebDriver()
                .findElement(controlLocation.getBy());
    }
    
    boolean isClickableWebElement(ControlLocation controlLocation) {
        // TODO Use Explicit
        return true;
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
                throw new ScreenCapturingCustomException(
                        String.format(ASearchContext.ERROR_STILL_VISIBLE, controlLocation.getValue()));
//                throw new RuntimeException(
//                        String.format(ASearchContext.ERROR_STILL_VISIBLE, controlLocation.getValue()));
            }
        }
        return isWebElementInvisible;
    }

    boolean isInvisibleWebElementWithText(ControlLocation controlLocation, String text){
        boolean isWebElementInvisible = false;
        WebElement webElementWithText;
        long beginTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - beginTime < ASearchContext.ONE_SECOND * getImplicitlyWaitTimeout()) {
            try {
                webElementWithText = BrowserUtils.get().getBrowser().getWebDriver()
                    .findElement(controlLocation.getBy());
                if (!webElementWithText.getText().toLowerCase().contains(text.toLowerCase().trim())) {
                    isWebElementInvisible = true;
                    break;
                }
                Thread.sleep(ASearchContext.ONE_SECOND / 2);
            } catch (NoSuchElementException e) {
                isWebElementInvisible = true;
                break;
            } catch (Exception e) {
                throw new ScreenCapturingCustomException(
                        String.format(ASearchContext.ERROR_STILL_VISIBLE, controlLocation.getValue()));
//                throw new RuntimeException(
//                        String.format(ASearchContext.ERROR_STILL_VISIBLE, controlLocation.getValue()));
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
                throw new ScreenCapturingCustomException(String.format(ASearchContext.ERROR_STILL_VISIBLE,
                        controlWrapper.getWebElement().getTagName()));
//                throw new RuntimeException(String.format(ASearchContext.ERROR_STILL_VISIBLE,
//                        controlWrapper.getWebElement().getTagName()));
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
                throw new ScreenCapturingCustomException(
                        String.format(ASearchContext.ERROR_TITLE_INVISIBLE, partialTitle));
//                throw new RuntimeException(
//                        String.format(ASearchContext.ERROR_TITLE_INVISIBLE, partialTitle));
            }
        }
        return isVisibleTitlePage;
    }

}
