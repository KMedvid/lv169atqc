package com.example.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class VerificatorTest {
    private WebDriver driver;

    @Test
    public void testVerificator() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/#/start");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Увійти")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@ng-model='loginForm.username']")).clear();
        driver.findElement(By.xpath("//input[@ng-model='loginForm.username']")).sendKeys("verificator-lv");
        driver.findElement(By.id("inputPassword")).clear();
        driver.findElement(By.id("inputPassword")).sendKeys("pass");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector("span.ng-scope")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@ng-click='openAddEmployeeModal()']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@ng-click='closeModal()']")).click();
        Thread.sleep(1000);
        //
        //driver.findElement(By.cssSelector("i.fa.fa-caret-down")).click();
        driver.findElement(By.partialLinkText("��� ������")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@ng-click='logout()']")).click();
        Thread.sleep(2000);
        System.out.println("\t*** logout done ***");
        //
        //((JavascriptExecutor) driver).executeScript(" $http({method: 'POST', url: 'logout'}).then(function () {window.location.replace('.'); });");
        //((JavascriptExecutor) driver).executeScript(" document.location.href = 'localhost:8080/#/logout';");
        //driver.get("http://localhost:8080/#/logout");
        //
        //Assert.assertEquals("�����", driver.findElement(By.linkText("�����")).getText());
    }

    @AfterTest
    public void tearDown() throws Exception {
        if (!driver.getCurrentUrl().contains("start")) {
            System.out.println("\t*** logout in progress ... ***");
            driver.get("http://localhost:8080/#/logout");
        }
        // driver.quit();
    }

}
