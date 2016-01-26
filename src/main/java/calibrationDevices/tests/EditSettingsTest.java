package calibrationDevices.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import calibrationDevices.data.IUrls;
import calibrationDevices.data.IUser;
import calibrationDevices.data.UrlRepository;
import calibrationDevices.data.UserRepository;
import calibrationDevices.pages.EditedProfileConfirmPage;
import calibrationDevices.pages.LoginStartPage;
import calibrationDevices.pages.ProfileInfoPage;

public class EditSettingsTest {
    public static final Logger logger = LoggerFactory.getLogger(AddNewUserTest.class);

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

    @DataProvider(parallel = true)
    public Object[][] existUsers() {
        return new Object[][] {
            { UserRepository.get().getProviderWorker(), UrlRepository.get().getLocalUrls() },
            };
    }
    
    @Test(dataProvider = "existUsers")
    public void checkProviderProfile(IUser existUser, IUrls urls) 
            throws InterruptedException {
        
        logger.info("test(EditSettingsTest) - START");

        ProfileInfoPage profileinfoPage = LoginStartPage.get().load(urls)
                .successProviderWorkerLogin(UserRepository
                        .get().getProviderWorker()).openProfileMenu().gotoProfileInfo();
        Thread.sleep(1000); // For better visual feedback
        System.out.print(profileinfoPage.getStartPageTitleText());
        System.out.print(ProfileInfoPage.PROFILE_TITLE);
        
        softAssert.assertEquals(profileinfoPage.getStartPageTitleText(),
                ProfileInfoPage.PROFILE_TITLE);
        Thread.sleep(3000); // For better visual feedback

        EditedProfileConfirmPage editedProfileConfirmPage = profileinfoPage
                .gotoSettingsPage().successEditedProfile(UserRepository
                        .get().getEditedProviderWorker());

        softAssert.assertEquals(profileinfoPage.getLoginText(),
                UserRepository.get().getEditedProviderWorker().getLogin());
        softAssert.assertEquals(profileinfoPage.getFirstNameText(),
                UserRepository.get().getEditedProviderWorker().getFirstname());
        softAssert.assertEquals(profileinfoPage.getLastNameText(),
                UserRepository.get().getEditedProviderWorker().getLastname());
        softAssert.assertEquals(profileinfoPage.getPhoneText(),
                UserRepository.get().getEditedProviderWorker().getPhone());
        softAssert.assertAll();
        
        logger.info("test(EditSettingsTest) - FINISH"); 
        
    }

}
