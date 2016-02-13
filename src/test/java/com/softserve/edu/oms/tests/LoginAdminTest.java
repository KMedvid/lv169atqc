package com.softserve.edu.oms.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.StartData;
import com.softserve.edu.atqc.exceptions.ScreenCapturingCustomException;
import com.softserve.edu.atqc.loggers.LoggerUtils;
import com.softserve.edu.atqc.specs.AssertWrapper;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.StartPage;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdminHomePage;
import com.softserve.edu.oms.pages.HomePage;
import com.softserve.edu.oms.pages.LoginValidatorPage;
import com.softserve.edu.oms.pages.LoginValidatorPage.LoginPageMessages;

public class LoginAdminTest {
    StartData startData = new StartData("http://ssu-oms:8180/OMS/login.htm",
            "http://ssu-oms:8180/OMS/logout.htm", "", "firefox", "");

    @BeforeClass
    public void oneTimeSetUp() {
    	//ConnectionUtils.get(DataSourceRepository.get().getJtdsMsSqlSsu());
        System.out.println("@BeforeClass - oneTimeSetUp");
        System.out.println("\t@BeforeClass - oneTimeSetUp, Thread Id = "
                + Thread.currentThread().getId());
    }

    @AfterClass
    public void oneTimeTearDown() {
        BrowserUtils.quitAll();
    }

    @BeforeMethod
    public void setUp() {
        //StartPage.get().addEventsPageLoadComplete();
        System.out.println("\t@BeforeMethod - setUp, Thread Id = "
                + Thread.currentThread().getId());
    }
    
    @AfterMethod
    public void tearDown() {
        StartPage.get().logout();
    }

    @DataProvider//(parallel = true)
    public Object[][] allUsers() {
        return new Object[][] {
                { UserRepository.get().getAdminUser() },
                //{ UserRepository.get().getCustomerUser() }
                };
    }
    
    //@Test(dataProvider = "allUsers")
    public void checkLoadPage(IUser user) throws InterruptedException {
        // Preconditions.
        LoggerUtils.get().infoLog("\tcheckLoadPage(), Thread Id = " + Thread.currentThread().getId());
        System.out.println("\tcheckLogin(), Thread Id = " + Thread.currentThread().getId());
        StartPage.get().load(startData);
        //BrowserUtils.get().getBrowser().getWebDriver().navigate().to("http://java.training.local:8080/#/start");
        //Thread.sleep(1000);
        // Check Load Page
        throw new ScreenCapturingCustomException("Run ScreenCapturingCustomException()");
    }

    @Test(dataProvider = "allUsers")
    public void checkLogin(IUser user) throws InterruptedException {
        // Preconditions.
        LoggerUtils.get().infoLog("\tcheckLogin(), Thread Id = " + Thread.currentThread().getId());
        System.out.println("\tcheckLogin(), Thread Id = "
                + Thread.currentThread().getId());
        StartPage.get().load(startData);
        // Test Steps.
        HomePage homepage = StartPage.get().load().successUserLogin(user);
        // Checking.
//        Assert.assertEquals(homepage.getFirstnameText(), user.getFirstname());
//        Assert.assertEquals(homepage.getLastnameText(), user.getLastname());
//        Assert.assertEquals(homepage.getRoleText(), user.getRole());
        //
        AssertWrapper.get()
            .forElement(homepage.getFirstnameText())
                .valueMatch(user.getFirstname())
                .next()
            .forElement(homepage.getLastnameText())
                .valueMatch(user.getLastname())
                .next()
            .forElement(homepage.getRoleText())
                .valueMatch(user.getRole());
        // Return to previous state.
        homepage.logout();
        // Check
        AssertWrapper.get().check();
    }

    @DataProvider//(parallel = true)
    public Object[][] adminProvider() {
        return new Object[][] {
            { UserRepository.get().getAdminUser() },
            };
    }

    //@Test(dataProvider = "adminProvider")
    public void checkAdminLogin(IUser adminUser) {
        // Preconditions.
        StartPage.get().load(startData);
        // Test Steps.
        AdminHomePage adminHomepage = StartPage.get().load().successAdminLogin(adminUser);
        // Checking.
//        Assert.assertEquals(adminHomepage.getFirstnameText(), adminUser.getFirstname());
//        Assert.assertEquals(adminHomepage.getLastnameText(), adminUser.getLastname());
//        Assert.assertEquals(adminHomepage.getRoleText(), adminUser.getRole());
        //
        AssertWrapper.get()
            //.forElement(adminHomepage.getFirstnameText())
            .forElement(adminHomepage.getFirstname())
                .valueMatch(adminUser.getFirstname())
                .next()
            .forElement(adminHomepage.getLastnameText())
                .valueMatch(adminUser.getLastname())
                .next()
            .forElement(adminHomepage.getRoleText())
                .valueMatch(adminUser.getRole());
        // Return to previous state.
        adminHomepage.logout();
        // Check
        AssertWrapper.get().check();
    }

    @DataProvider//(parallel = true)
    public Object[][] invalidProvider() {
        return new Object[][] {
            { UserRepository.get().getInvalidUser() },
            };
    }

    //@Test(dataProvider = "invalidProvider")
    public void checkInvalidLogin(IUser invalidUser) {
        // Preconditions.
        StartPage.get().load(startData);
        // Test Steps.
        LoginValidatorPage loginValidatorPage = StartPage.get().load().unSuccesfulLogin(invalidUser);
        // Checking.
//        Assert.assertEquals(loginValidatorPage.getStartValidatorText(),
//                LoginPageMessages.START_VALIDATOR_MESSAGE.toString());
        AssertWrapper.get()
            .forElement(loginValidatorPage.getValidatorText())
                .valueMatch(LoginPageMessages.START_VALIDATOR_MESSAGE.toString());
        // Return to previous state.
        // Check
        AssertWrapper.get().check();
    }

}
