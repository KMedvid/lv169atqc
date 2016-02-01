package com.softserve.edu.md.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.atqc.data.StartData;
import com.softserve.edu.atqc.tools.BrowserUtils;

public class VerificatorTest {
    StartData startData = new StartData("http://localhost:8080/#/start",
            "http://localhost:8080/#/logout", "", "chrome", "");

    @AfterClass
    public void oneTimeTearDown() {
        BrowserUtils.quitAll();
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
        //
//        driver.findElement(By.cssSelector("span.ng-scope")).click();
//        driver.findElement(By.xpath("//button[@ng-click='openAddEmployeeModal()']")).click();
//        driver.findElement(By.xpath("//button[@ng-click='closeModal()']")).click();
//        //
//        //driver.findElement(By.cssSelector("i.fa.fa-caret-down")).click();
//        driver.findElement(By.partialLinkText("��� ������")).click();
//        driver.findElement(By.xpath("//div[@ng-click='logout()']")).click();
//        System.out.println("\t*** logout done ***");
        //
        //((JavascriptExecutor) driver).executeScript(" $http({method: 'POST', url: 'logout'}).then(function () {window.location.replace('.'); });");
        //((JavascriptExecutor) driver).executeScript(" document.location.href = 'localhost:8080/#/logout';");
        //driver.get("http://localhost:8080/#/logout");
        //
        //Assert.assertEquals("�����", driver.findElement(By.linkText("�����")).getText());
    }

}
