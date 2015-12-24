package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginAdmin {
    private WebDriver driver;
    
    @BeforeClass
    public void oneTimeSetUp() {
        System.out.println("@BeforeClass - oneTimeSetUp() START");
        //driver = new FirefoxDriver();
        driver = new HtmlUnitDriver(true);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("@BeforeClass - oneTimeSetUp() DONE");
    }

    @AfterClass
    public void oneTimeTearDown() {
        driver.quit();
        System.out.println("@AfterClass - oneTimeTearDown()");
    }

    @Test
    public void testUnit() throws Exception {
        System.out.println("@Test -  testUnit() START");
        driver.get("http://localhost:8080/OMS");
        driver.findElement(By.name("j_username")).sendKeys("iva");
        driver.findElement(By.name("j_password")).sendKeys("qwerty");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.xpath("//a[@class='spec']")).click();
        System.out.println("@Test -  testUnit() DONE");
    }
    
    @Test
    public void testAdm() throws Exception {
//        WebDriver driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Precondition
        driver.get("http://localhost:8080/OMS");
        // Test Steps
        WebElement login = driver.findElement(By.name("j_username"));
        WebElement password = driver.findElement(By.name("j_password"));
        WebElement button = driver.findElement(By.name("submit"));
        //
        login.sendKeys("iva");
        password.sendKeys("qwerty");
        Thread.sleep(2000);
        button.click();
        Thread.sleep(2000);
        // Prepare to Check
        String lastname = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
        //Assert.assertEquals(s, "horoshko");
        // Return to Previous State
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='spec']")).click();
        Thread.sleep(2000);
        //driver.quit();
        // Checking
        Assert.assertEquals(lastname, "horoshko");
    }

    @Test
    public void testInvalidLogin() throws InterruptedException {
//        WebDriver driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Precondition
        driver.get("http://www.google.com");
        Thread.sleep(2000);
        driver.get("http://localhost:8080/OMS");
        Thread.sleep(2000);
        // Test Steps
        WebElement login = driver.findElement(By.name("j_username"));
        WebElement password = driver.findElement(By.name("j_password"));
        WebElement button = driver.findElement(By.name("submit"));
        //
        login.sendKeys("iva1");
        password.sendKeys("qwerty1");
        button.click();
        // Prepare to Check
        String lastname = driver.findElement(By.xpath("//font[@color='red']")).getText();
        // Return to Previous State
        Thread.sleep(2000);
        driver.navigate().back();
        //driver.quit();
        // Checking
        Assert.assertTrue(lastname.startsWith("Your login attempt was not successful, try again"));
    }

}
