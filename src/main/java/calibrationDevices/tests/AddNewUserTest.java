package calibrationDevices.tests;

import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import calibrationDevices.data.IUrls;
import calibrationDevices.data.IUser;
import calibrationDevices.data.UrlRepository;
import calibrationDevices.data.UserRepository;
import calibrationDevices.pages.AddNewWorkerConfirmPage;
import calibrationDevices.pages.EmployeesPage;
import calibrationDevices.pages.LoginStartPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddNewUserTest {
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

    @DataProvider(parallel = true)
    public Object[][] existUsers() {
        return new Object[][] {
            { UserRepository.get().getProviderGeneralUser(), UrlRepository.get().getLocalUrls()},
            };
    }
    
    @Test(dataProvider = "existUsers")
    public void checkProviderProfile(IUser existUser, IUrls urls) throws InterruptedException {
        
        logger.info("test(AddNewUserTest) - START");

        AddNewWorkerConfirmPage  workerAdded = LoginStartPage.get().load(urls)
                .successProviderLogin(UserRepository.get().getProviderGeneralUser())
                .gotoEmployeesPage().gotoAddNewWorkerFormPage()
                .successAddNewWorker(UserRepository.get().getNewWorker());
        Thread.sleep(1000); // For better visual feedback

        System.out.print(workerAdded.getStartSuccessMessageText());    
        softAssert.assertEquals(workerAdded.getStartSuccessMessageText(),
                AddNewWorkerConfirmPage.START_SUCCESS_MESSAGE);

        EmployeesPage employeesPage = workerAdded.enterOkButton();
        employeesPage.allWorkersInfoTable();
        Thread.sleep(5000);
        
        softAssert.assertTrue(employeesPage.getWorkerByLogin
                (UserRepository.get().getNewWorker().getLogin()) != null);
        softAssert.assertAll();
        logger.info("test(AddNewUserTest) - FINISH");
    }

}
