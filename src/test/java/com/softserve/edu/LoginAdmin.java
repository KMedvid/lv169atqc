package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginAdmin {
    public static final Logger logger = LoggerFactory.getLogger(LoginAdmin.class);
    private WebDriver driver;
    
    @BeforeClass
    public void oneTimeSetUp() {
        logger.info("@BeforeClass - oneTimeSetUp() START");
        System.out.println("@BeforeClass - oneTimeSetUp() START");
        driver = new FirefoxDriver();
        //driver = new HtmlUnitDriver(true);
        //((HtmlUnitDriver) driver).setJavascriptEnabled(true);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("@BeforeClass - oneTimeSetUp() DONE");
        logger.info("@BeforeClass - oneTimeSetUp() DONE");
    }

    @AfterClass
    public void oneTimeTearDown() {
        logger.info("oneTimeTearDown() - oneTimeSetUp() START");
        driver.quit();
        System.out.println("@AfterClass - oneTimeTearDown()");
        logger.info("oneTimeTearDown() - oneTimeSetUp() DONE");
        Reporter.log("<BR><P><FONT color='green' size='3'><B>@Test</B> -  oneTimeTearDown() DONE</FONT></P>");
    }

    @Test
    public void testUnit() throws Exception {
        logger.info("@Test -  testUnit() START");
        Reporter.log("<BR><P><FONT color='green' size='3'><B>@Test</B> -  testUnit() START</FONT></P>");
        System.out.println("@Test -  testUnit() START");
        //logger.info("Goto http://localhost:8080/OMS");
        //driver.get("http://localhost:8080/OMS");
        logger.info("Goto http://localhost:8080/OMS");
        //Reporter.log("Goto http://localhost:8080/OMS");
        Reporter.log("<BR><P><FONT color='blue'><B>@Test</B> Goto http://localhost:8080/OMS</FONT></P>");
        //driver.get("http://ssu-oms.training.local:8180/OMS/login.htm");
        driver.get("http://localhost:8080/OMS");
        logger.info("Creating Web Elements");
        driver.findElement(By.name("j_username")).sendKeys("iva");
        driver.findElement(By.name("j_password")).sendKeys("qwerty");
        driver.findElement(By.name("submit")).click();
        logger.info("Goto Admin Info Page");
        //
        //  Thread.sleep(2000);
        //File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // For example copy somewhere
        //FileUtils.copyFile(scrFile, new File("test-output/screenshot_HtmlUnitDriver.png"));
        //
        logger.info("Goto Login Page");
        driver.findElement(By.xpath("//a[@class='spec']")).click();
        logger.info("Logout Succesfull");
        System.out.println("@Test -  testUnit() DONE");
        logger.info("@Test -  testUnit() DONE");
        //Reporter.log("@Test -  testUnit() DONE");
        Reporter.log("<BR><P><FONT color='green' size='3'><B>@Test</B> -  testUnit() DONE</FONT></P>");
    }
    
    //@Test
    public void testAdm() throws Exception {
        logger.info("@Test -  testAdm() START");
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
        logger.info("@Test -  testAdm() DONE");
    }

    //@Test
    public void testInvalidLogin() throws InterruptedException {
        logger.info("@Test -  testInvalidLogin() START");
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
        logger.info("@Test -  testInvalidLogin() DONE");
    }

}
