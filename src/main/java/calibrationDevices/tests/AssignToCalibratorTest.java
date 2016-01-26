package calibrationDevices.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import calibrationDevices.data.IUrls;
import calibrationDevices.data.IUser;
import calibrationDevices.data.UrlRepository;
import calibrationDevices.data.UserRepository;
import calibrationDevices.data.VerificationsRepository;
import calibrationDevices.pages.AssignVerificationToWorkerPage;
import calibrationDevices.pages.LoginStartPage;
import calibrationDevices.pages.NewVerificationsPage;
import calibrationDevices.pages.ProviderHomePage;
import calibrationDevices.pages.SendToCalibratorPage;

public class AssignToCalibratorTest {
    
    public static final Logger logger = LoggerFactory.getLogger(AssignToCalibratorTest.class);

    private SoftAssert softAssert;
    
    @BeforeClass
    public void oneTimeSetUp() {
        softAssert = new SoftAssert();
    }


    @DataProvider(parallel = true)
    public Object[][] existUsers() {
        return new Object[][] {
            { UserRepository.get().getProviderGeneralUser(), UrlRepository.get()
                .getSoftServeUrls() },
            };
    }
    
    @Test(dataProvider = "existUsers")
    public void checkNewVerificationAdded(IUser existUser, IUrls urls)
            throws InterruptedException {
        
        logger.info("test(MainMenuProviderTest) - START");

        ProviderHomePage providerHomePage = LoginStartPage.get().load(urls)
                .successProviderLogin(UserRepository.get().getProviderGeneralUser());
        providerHomePage.gotoProviderMainPanelPage();

        Thread.sleep(1000); // For better visual feedback
        
        // Check if New Verifications page can be opened
        NewVerificationsPage newVerificationsPage = providerHomePage
                .gotoNewVerificationsPage();
        
        Thread.sleep(1000); // For better visual feedback
        newVerificationsPage.searchVerificationById(VerificationsRepository.get().getVerification());
        Thread.sleep(2000); // For better visual feedback
        AssignVerificationToWorkerPage assignVerificationToWorkerPage = newVerificationsPage.assignToWorker();
        NewVerificationsPage newVerificationsPageassigned = assignVerificationToWorkerPage.enterOkButton();
        Thread.sleep(2000); // For better visual feedback
        SendToCalibratorPage sendToCalibratorPage = newVerificationsPage
                .assignVerificationToCalibrator(VerificationsRepository
                        .get().getVerification().getVerificationsId());
        newVerificationsPage = sendToCalibratorPage.sendButton();
        Thread.sleep(2000); // For better visual feedback
        
        softAssert.assertAll();
        logger.info("test(MainMenuProviderTest) - FINISH");
    }

}
