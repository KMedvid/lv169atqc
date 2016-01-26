package calibrationDevices.tests;


import org.openqa.selenium.WebDriver;
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
import calibrationDevices.data.IVerifications;
import calibrationDevices.data.UrlRepository;
import calibrationDevices.data.UserRepository;
import calibrationDevices.data.VerificationsRepository;
import calibrationDevices.pages.ApplyForVerificationPage;
import calibrationDevices.pages.DeleteVerificationValidatorPage;
import calibrationDevices.pages.LoginStartPage;
import calibrationDevices.pages.NewVerificationsPage;
import calibrationDevices.pages.ProviderHomePage;
import calibrationDevices.pages.StartPageMD;

public class SketchTestofNewVerification {
    
    public static final Logger logger = LoggerFactory.getLogger(LoginNewTest.class);

    private SoftAssert softAssert;
    private String verificationID = "";
    
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
//      LoginStartPage.get().quit();
      LoginStartPage.get().logout();
    }


    @DataProvider
    public Object[][] verification() {
        return new Object[][]{
            {UserRepository.get().getProviderGeneralUser(), VerificationsRepository
                .get().getVerification(), UrlRepository.get().getSoftServeUrls()},
        };
    }
    
    @DataProvider
    public Object[][] existUsers() {
        return new Object[][] {
            { UserRepository.get().getProviderGeneralUser(), UrlRepository.get()
                .getSoftServeUrls() },
            };
    }

    @Test(dataProvider = "verification", groups="createVerification")
    public void checkNewVerification(IUser providerUser, IVerifications verificaton, IUrls urls) 
            throws InterruptedException {
        
        StartPageMD startPage = LoginStartPage.get().load(urls)
                .gotoStartPage();
        ApplyForVerificationPage applyForVerificationPage = startPage.applyForVerification();
        applyForVerificationPage.sendVerification(verificaton);
        Thread.sleep(3000); // For better visual feedback
        verificationID = applyForVerificationPage.getVerifictionID();
    }
    
    @Test(dataProvider = "existUsers",  dependsOnGroups="createVerification")
    public void deleteVerification(IUser providerUser, IUrls urls) throws InterruptedException {
        logger.info("test(MainMenuProviderTest) - START");       

        ProviderHomePage providerHomePage = LoginStartPage.get().load(urls)
                .successProviderLogin(UserRepository.get().getProviderGeneralUser());
        Thread.sleep(3000); // For better visual feedback
        NewVerificationsPage newVerificationsPage = providerHomePage
                .gotoNewVerificationsPage();
        DeleteVerificationValidatorPage deleteVerification = newVerificationsPage
                .deleteVerification(verificationID);
        deleteVerification.enterOkButton(VerificationsRepository.get().getVerification());
    }


}
