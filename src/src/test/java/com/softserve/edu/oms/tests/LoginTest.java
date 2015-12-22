package com.softserve.edu.oms.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepositoryStatic;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.LoginPage;
import com.softserve.edu.oms.pages.LoginValidatorPage;

public class LoginTest {
    private WebDriver driver;
    private SoftAssert softAssert;
	
    @BeforeClass
    public void oneTimeSetUp() {
        softAssert = new SoftAssert();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void oneTimeTearDown() {
        //driver.quit();
        System.out.println("@AfterClass - oneTimeTearDown");
    }

    @AfterMethod
    public void tearDown() {
        driver.get("http://localhost:8080/OMS/logout.htm");
        System.out.println("@AfterMethod - tearDown");
    }

	@DataProvider
	public Object[][] invalidUsers() {
		return new Object[][] { 
            //{ new User("ivanka","horoshko","iva1","qwerty1","mail@gmail.com","West","Administrator") },
		    { UserRepositoryStatic.getInvalidUser() },
		};
	}

	@Test(dataProvider = "invalidUsers")
	public void checkInvalidLogin(IUser invalidUser) throws InterruptedException {
	    // Precondition
	    driver.get("http://localhost:8080/OMS");
		// Test Operation
//	    LoginPage loginPage = new LoginPage(driver);
//	    LoginValidatorPage loginValidatorPage = loginPage.unsuccessfulLogin(invalidUser); 
		LoginValidatorPage loginValidatorPage = new LoginPage(driver)
		        .unsuccessfulLogin(invalidUser);
		// Check
		Assert.assertTrue(loginValidatorPage.getValidatorText()
		        .startsWith(LoginValidatorPage.START_VALIDATOR_MESSAGE));
		Assert.assertEquals(loginValidatorPage.getStartValidatorText() ,
		        LoginValidatorPage.START_VALIDATOR_MESSAGE);
		Thread.sleep(2000);
		// Return
	}

	@DataProvider
	public Object[][] adminUsers() {
		return new Object[][] {
				//{ new User("ivanka","horoshko","iva","qwerty","mail@gmail.com","West","Administrator") },
	            { UserRepositoryStatic.getAdminUser() },
		};
	}

	@Test(dataProvider = "adminUsers")
	public void checkAdminLogin(IUser adminUser) throws InterruptedException {
        // Precondition
        driver.get("http://localhost:8080/OMS");
        // Test Operation
		AdminHomePage adminHomePage = new LoginPage(driver)
				.successAdminLogin(adminUser);
		// Check
//		Assert.assertEquals(adminHomePage.getFirstnameText(),
//				adminUser.getFirstname());
//		Assert.assertEquals(adminHomePage.getLastnameText(),
//				adminUser.getLastname());
//        Assert.assertEquals(adminHomePage.getRoleText(),
//                adminUser.getRole());
		softAssert.assertEquals(adminHomePage.getFirstnameText(),
                adminUser.getFirstname());
		int i=1/0;
		System.out.println(i);
		softAssert.assertEquals(adminHomePage.getLastnameText(),
                adminUser.getLastname());
		softAssert.assertEquals(adminHomePage.getRoleText(),
                adminUser.getRole()+"111");
		Thread.sleep(2000);
		// Return
		adminHomePage.gotoLogout();
		// Final Check
		softAssert.assertAll();
	}

}
