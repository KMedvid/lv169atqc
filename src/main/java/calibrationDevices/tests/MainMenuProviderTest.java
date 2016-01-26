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
import calibrationDevices.pages.EmployeeStatisticsPage;
import calibrationDevices.pages.EmployeesPage;
import calibrationDevices.pages.LoginStartPage;
import calibrationDevices.pages.NewVerificationsPage;
import calibrationDevices.pages.ProviderHomePage;
import calibrationDevices.pages.VerificationArchivePage;

public class MainMenuProviderTest {
    
    public static final Logger logger = LoggerFactory.getLogger(MainMenuProviderTest.class);

    private SoftAssert softAssert;
    
    @BeforeClass
    public void oneTimeSetUp() {
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void oneTimeTearDown() {
        LoginStartPage.get().quit();
    }

    @AfterMethod
    public void tearDown() {
        LoginStartPage.get().logout();
    }

    @DataProvider(parallel = true)
    public Object[][] existUsers() {
        return new Object[][] {
            { UserRepository.get().getProviderUser(), UrlRepository.get()
                .getLocalUrls() },
            };
    }
    
    @Test(dataProvider = "existUsers")
    public void checkMainMenuProvider(IUser existUser, IUrls urls)
            throws InterruptedException {
        
        logger.info("test(MainMenuProviderTest) - START");

        ProviderHomePage providerHomePage = LoginStartPage.get().load(urls)
                .successProviderLogin(UserRepository.get().getProviderUser());
        providerHomePage.gotoProviderMainPanelPage();

        Thread.sleep(1000); // For better visual feedback
        
        // Check if New Verifications page can be opened
        NewVerificationsPage newVerificationsPage = providerHomePage
                .gotoNewVerificationsPage();
        softAssert.assertEquals(newVerificationsPage.getStartPageTitleText(),
                NewVerificationsPage.PAGE_TITLE);
        Thread.sleep(1000); // For better visual feedback
        
        // Check if New Employees page can be opened
        EmployeesPage employeesPage = providerHomePage.gotoEmployeesPage();
        softAssert.assertEquals(employeesPage.getStartPageTitleText(),
                EmployeesPage.PAGE_TITLE);
        Thread.sleep(1000); // For better visual feedback
        
        // Check if Verifications Archive page can be opened
        VerificationArchivePage verificationArchivePage = providerHomePage
                .gotoVerificationArchivePage();
        softAssert.assertEquals(verificationArchivePage.getStartPageTitleText(),
                VerificationArchivePage.PAGE_TITLE);
        Thread.sleep(1000); // For better visual feedback
        
        // Check if Employee Statistics Page page can be opened
        EmployeeStatisticsPage employeeStatisticsPage = providerHomePage
                .gotoEmployeeStatisticsPage();
        softAssert.assertEquals(employeeStatisticsPage.getStartPageTitleText(),
                EmployeeStatisticsPage.PAGE_TITLE);
        Thread.sleep(1000); // For better visual feedback
        
        softAssert.assertAll();
        logger.info("test(MainMenuProviderTest) - FINISH");
    }

}
