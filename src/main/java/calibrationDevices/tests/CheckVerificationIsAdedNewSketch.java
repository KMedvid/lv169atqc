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

public class CheckVerificationIsAdedNewSketch {
    
    public static final Logger logger = LoggerFactory.getLogger(LoginNewTest.class);

    private SoftAssert softAssert;
    private String verificationID = "2501201610008";
    
    @BeforeClass
    public void oneTimeSetUp() {
        softAssert = new SoftAssert();

    }

    @AfterClass
    public void oneTimeTearDown() {
        System.out.println("@AfterClass: ThreadId = " + Thread.currentThread().getId());
 //       LoginStartPage.get().quit();
    }

    @AfterMethod
    public void tearDown() {
      System.out.println("@AfterMethod: ThreadId = " + Thread.currentThread().getId());
    }

    @DataProvider
    public Object[][] verification() {
        return new Object[][]{
            {UserRepository.get().getProviderGeneralUser(), VerificationsRepository.get().getVerification(), UrlRepository.get().getSoftServeUrls()},
        };
    }
    
    @DataProvider
    public Object[][] existUsers() {
        return new Object[][] {
            { UserRepository.get().getProviderGeneralUser(), UrlRepository.get()
                .getSoftServeUrls() },
            };
    }

    @Test(dataProvider = "verification", groups="RunFirst")
    public void createNewVerification(IUser providerUser,IVerifications verification, IUrls urls) throws InterruptedException {
        StartPageMD startPage = LoginStartPage.get().load(urls)
                .gotoStartPage();
        ApplyForVerificationPage applyForVerificationPage = startPage.applyForVerification();
        applyForVerificationPage.sendVerification(verification);
        Thread.sleep(3000); // For better visual feedback
        verificationID = applyForVerificationPage.getVerifictionID();
    }
    
    @Test(dataProvider = "verification", groups="RunSecond", dependsOnGroups="RunFirst")
    public void checkNewVerification(IUser providerUser,IVerifications verification, IUrls urls) throws InterruptedException {
        
        logger.info("test(MainMenuProviderTest) - START");
        ProviderHomePage providerHomePage = LoginStartPage.get().load(urls)
                .successProviderLogin(UserRepository.get().getProviderGeneralUser());
        providerHomePage.gotoProviderMainPanelPage();

        Thread.sleep(1000); // For better visual feedback
        
        // Check if New Verifications page can be opened
        NewVerificationsPage newVerificationsPage = providerHomePage
                .gotoNewVerificationsPage();
        Thread.sleep(1000); // For better visual feedback
        Thread.sleep(2000); // For better visual feedback
        newVerificationsPage.searchVerificationByIdCOde(verificationID);
        Thread.sleep(2000); // For better visual feedback
        softAssert.assertEquals (verificationID.trim(),
                newVerificationsPage.getVerificationsIdText().trim()); 
        softAssert.assertAll();
    }
    
   
    @Test(dataProvider = "existUsers",  dependsOnGroups="RunSecond")
    public void deleteVerification(IUser providerUser, IUrls urls) throws InterruptedException {
        logger.info("test(MainMenuProviderTest) - START");       

        ProviderHomePage providerHomePage = LoginStartPage.get().load(urls)
                .successProviderLogin(UserRepository.get().getProviderGeneralUser());
        Thread.sleep(3000); // For better visual feedback
        NewVerificationsPage newVerificationsPage = providerHomePage
                .gotoNewVerificationsPage();
        Thread.sleep(1000); // For better visual feedback
        
        DeleteVerificationValidatorPage deleteVerification = newVerificationsPage.deleteVerification(verificationID);
        deleteVerification.enterOkButton(VerificationsRepository.get().getVerification());
    }


}
