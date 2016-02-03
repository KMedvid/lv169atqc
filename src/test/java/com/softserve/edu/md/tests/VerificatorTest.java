package com.softserve.edu.md.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.LabelClickable;
import com.softserve.edu.atqc.controls.Link;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.atqc.data.StartData;
import com.softserve.edu.atqc.tools.BrowserUtils;

public class VerificatorTest {
    StartData startData = new StartData("http://localhost:8080/#/start",
            "http://localhost:8080/#/logout", "", "chrome", "");

    @AfterClass
    public void oneTimeTearDown() {
        //BrowserUtils.quitAll();
    }

    @Test
    public void testVerificator() throws Exception {
        BrowserUtils.get(startData);
        BrowserUtils.get().getBrowser().getWebDriver().navigate().to("http://localhost:8080/#/start");
        Link.get().getByPartialLinkText("Увійти").click();
        TextField.get().getByXpath("//input[@ng-model='loginForm.username']").clear();
        TextField.get().getByXpath("//input[@ng-model='loginForm.username']").sendKeys("verificator-lv");
        TextField.get().getById("inputPassword").clear();
        TextField.get().getById("inputPassword").sendKeys("pass");
        Button.get().getByXpath("//button[@type='submit']").click();
        //
        LabelClickable.get().getByXpath("//span[@translate='EMPLOYEE']").click();
        Button.get().getByXpath("//button[@ng-click='openAddEmployeeModal()']").click();
        Button.get().getByXpath("//button[@ng-click='closeModal()']").click();
        Button.get().getByXpath("//button[@ng-click='submit()']").click();
        //
        //Thread.sleep(1000);
//        new Actions(BrowserUtils.get().getBrowser().getWebDriver())
//            .moveToElement(BrowserUtils.get().getBrowser().getWebDriver()
//                    .findElement(By.xpath("//a[@class='dropdown-toggle']"))).perform();
//        Thread.sleep(4000);
//        new Actions(BrowserUtils.get().getBrowser().getWebDriver())
//            .moveToElement(BrowserUtils.get().getBrowser().getWebDriver()
//                    .findElement(By.xpath("//a[@class='dropdown-toggle']"))).click();
//        BrowserUtils.get().getBrowser().getWebDriver()
//            .findElement(By.xpath("//a[@class='dropdown-toggle']")).sendKeys(Keys.ENTER);
        //
        //LabelClickable.get().getByPartialLinkText("Оззі Озборн").click();
        //LabelClickable.get().getByCssSelector("i.fa.fa-caret-down").click();
//        Thread.sleep(1000);
//        System.out.println(" +++++ opacity ="
//                + (boolean) ((JavascriptExecutor) BrowserUtils.get().getBrowser()
//                        .getWebDriver()).executeScript("return $('#employeeModule')[0].style.opacity == ''")
//                );
        Link.get().getByXpath("//a[@class='dropdown-toggle']").click();
        LabelClickable.get().getByXpath("//div[@ng-click='logout()']").click();
        //
        System.out.println("\t*** logout done ***");
        //
        //((JavascriptExecutor) driver).executeScript(" $http({method: 'POST', url: 'logout'}).then(function () {window.location.replace('.'); });");
        //((JavascriptExecutor) driver).executeScript(" document.location.href = 'localhost:8080/#/logout';");
        //driver.get("http://localhost:8080/#/logout");
        //
        //Assert.assertEquals("�����", driver.findElement(By.linkText("�����")).getText());
    }

}
