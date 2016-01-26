package calibrationDevices.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import calibrationDevices.data.IUrls;
import calibrationDevices.data.IUser;
import calibrationDevices.data.UrlRepository;
import calibrationDevices.data.UserRepository;
import calibrationDevices.pages.LoginStartPage;
import calibrationDevices.pages.LoginValidatorPage;
import calibrationDevices.pages.ProviderHomePage;

public class LoginNewTest {
    
    public static final Logger logger = LoggerFactory.getLogger(LoginNewTest.class);

    private SoftAssert softAssert;
    
    @BeforeClass
    public void oneTimeSetUp() {
        softAssert = new SoftAssert();

    }

    @AfterClass
    public void oneTimeTearDown() {
        System.out.println("@AfterClass: ThreadId = " + Thread.currentThread().getId());
        LoginStartPage.get().quit();
    }

    @AfterMethod
    public void tearDown() {
      System.out.println("@AfterMethod: ThreadId = " + Thread.currentThread().getId());
      LoginStartPage.get().logout();
    }

    @DataProvider
    public Object[][] invalidUsers() {
        return new Object[][] { 
            { UserRepository.get().getInvalidUser(), UrlRepository.get().getLocalUrls() },
        };
    }

    @Test(dataProvider = "invalidUsers")
    public void checkInvalidLogin(IUser invalidUser, IUrls urls) throws InterruptedException {
        // Precondition
        logger.info("test(LoginNewTest) - START");
        LoginValidatorPage loginValidatorPage = LoginStartPage.get().load(urls)
                .unsuccessfulLogin(UserRepository.get().getInvalidUser());
        Thread.sleep(1000);

        softAssert.assertEquals(loginValidatorPage.getStartValidatorText() ,
                LoginValidatorPage.START_VALIDATOR_MESSAGE);
    }

    @DataProvider
    public Object[][] providerUsers() {
        return new Object[][]{
            {UserRepository.get().getProviderUser(), UrlRepository.get().getLocalUrls()},
        };
    }

    @Test(dataProvider = "providerUsers")
    public void checkPoviderLogin(IUser providerUser, IUrls urls) throws InterruptedException {
        ProviderHomePage providerHomePage = LoginStartPage.get().load(urls)
                .successProviderLogin(UserRepository.get().getProviderUser());
        Thread.sleep(1000);

        // Check if provider is logged in
        softAssert.assertEquals(providerHomePage.getUserNameText(),
                providerUser.getFirstname());

        softAssert.assertAll();
        logger.info("test(LoginNewTest) - FINISH");
    }

}
