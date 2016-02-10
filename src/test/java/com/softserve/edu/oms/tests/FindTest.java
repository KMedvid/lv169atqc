package com.softserve.edu.oms.tests;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.ConnectionUtils;
import com.softserve.edu.atqc.data.StartData;
import com.softserve.edu.atqc.specs.AssertWrapper;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.oms.dao.UserDao;
import com.softserve.edu.oms.data.DataSourceRepository;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.ServiceUtils;
import com.softserve.edu.oms.data.StartPage;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.pages.HomePage;
import com.softserve.edu.oms.services.UserService;

public final class FindTest {
    StartData startData = new StartData("http://ssu-oms:8180/OMS/login.htm",
            "http://ssu-oms:8180/OMS/logout.htm", "", "chrome", "");

    @BeforeClass
    public void oneTimeSetUp() {
    	ConnectionUtils.get(DataSourceRepository.get().getJtdsMsSqlSsu());
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
        System.out.println("\t@BeforeMethod - setUp, Thread Id = "
                + Thread.currentThread().getId());
    }
    
    @AfterMethod
    public void tearDown() {
        StartPage.get().logout();
    }

    @DataProvider//(parallel = true)
    public Object[][] existUsers() {
        return new Object[][] {
            { UserRepository.get().getAdminUser() },
            };
    }

    //@Test(dataProvider = "existUsers")
    public void checkExistUsersFind(IUser existUser) {
        // PreCondition
        StartPage.get().load(startData);
        AdministrationPage administrationPage = StartPage.get().load() 
                .successAdminLogin(UserRepository.get().getAdminUser())
                .gotoAdministration();
        // Test Operation
        administrationPage.searchByLoginName(existUser);
        // Save Actual Result. Preparation for Checking
        Assert.assertEquals(administrationPage.getFirstnameText(),
                existUser.getFirstname());
        Assert.assertEquals(administrationPage.getLoginText(),
                existUser.getLogin());
//        AssertWrapper.get()
//                .forElement(administrationPage.getFirstname().getText())
//                    .valueMatch(existUser.getFirstname())
//                    .next()
//                .forElement(administrationPage.getLogin().getText())
//                    .valueMatch(existUser.getLogin());
        // Return to Previous State
        administrationPage.logout();
        // Checking
//        AssertWrapper.get().check();
    }

    @DataProvider//(parallel = true)
    public Object[][] newUsers() {
        return new Object[][] {
            { UserRepository.get().getNewUser() },
            };
    }

    //@Test(dataProvider = "newUsers")
    public void checkNewUserCreate(IUser newUser) throws InterruptedException {
        // PreCondition
        StartPage.get().load(startData);
        CreateNewUserPage createNewUserPage =StartPage.get().load() 
                .successAdminLogin(UserRepository.get().getAdminUser())
                .gotoAdministration()
                .gotoCreateNewUser();
        // Test Operation
        AdministrationPage administrationPage = createNewUserPage
                .createNewUser(newUser);
        administrationPage.searchByLoginName(newUser);
        Thread.sleep(4000);
        // Save Actual Result. Preparation for Checking
//        Assert.assertEquals(administrationPage.getFirstnameText(),
//                newUser.getFirstname());
//        Assert.assertEquals(administrationPage.getLoginText(),
//                newUser.getLogin());
        AssertWrapper.get()
                .forElement(administrationPage.getFirstname().getText())
                    .valueMatch(newUser.getFirstname())
                    .next()
                .forElement(administrationPage.getLogin().getText())
                    .valueMatch(newUser.getLogin());
        // Test Operation
        HomePage homePage = administrationPage.logout()
                .successUserLogin(newUser);
        Thread.sleep(4000);
        // Save Actual Result. Preparation for Checking
//        Assert.assertEquals(homePage.getFirstnameText(),
//                newUser.getFirstname());
//        Assert.assertEquals(homePage.getLastnameText(),
//                newUser.getLastname());
//        Assert.assertEquals(homePage.getRoleText(),
//                newUser.getRole());
        AssertWrapper.get()
                .forElement(homePage.getFirstname())
                    .valueMatch(newUser.getFirstname())
                    .valueStartsWith(newUser.getFirstname().substring(0,1))
                    .next()
                .forElement(homePage.getLastname())
                    .valueMatch(newUser.getLastname())
                    .next()
                .forElement(homePage.getRole().getText())
                    .valueMatch(newUser.getRole());
        // Test Operation
        administrationPage = homePage.logout()
                .successAdminLogin(UserRepository.get().getAdminUser())
                .gotoAdministration();
        Thread.sleep(4000);
        // Return to Previous State
        administrationPage.deleteByLoginName(newUser);
        Thread.sleep(4000);
        UserService.get().deleteUsersByLogin(newUser.getLogin());
        System.out.println(UserService.get().getUserFirstnameByLogin(newUser.getLogin()));
        // Save Actual Result. Preparation for Checking
//        AssertWrapper.get()
//                .forElement(administrationPage.getAlert())
//                .valueMatchInLastMessage(
//                        MessageRepository.AdministrationPageNotes.ALERT_DELETE_MESSAGE
//                                .toString());
        administrationPage.logout();
        // Checking
        AssertWrapper.get().check();
    }

    @Test(dataProvider = "newUsers")
    public void checkNewUserCreateMock(IUser newUser) throws InterruptedException {
        // PreCondition
        StartPage.get().load(startData);
        CreateNewUserPage createNewUserPage =StartPage.get().load() 
                .successAdminLogin(UserRepository.get().getAdminUser())
                .gotoAdministration()
                .gotoCreateNewUser();
        // Test Operation
        AdministrationPage administrationPage = createNewUserPage
                .createNewUser(newUser);
        administrationPage.searchByLoginName(newUser);
        Thread.sleep(4000);
        // Save Actual Result. Preparation for Checking
//        Assert.assertEquals(administrationPage.getFirstnameText(),
//                newUser.getFirstname());
//        Assert.assertEquals(administrationPage.getLoginText(),
//                newUser.getLogin());
        AssertWrapper.get()
                .forElement(administrationPage.getFirstname().getText())
                    .valueMatch(newUser.getFirstname())
                    .next()
                .forElement(administrationPage.getLogin().getText())
                    .valueMatch(newUser.getLogin());
        // Test Operation
        HomePage homePage = administrationPage.logout()
                .successUserLogin(newUser);
        Thread.sleep(4000);
        // Save Actual Result. Preparation for Checking
//        Assert.assertEquals(homePage.getFirstnameText(),
//                newUser.getFirstname());
//        Assert.assertEquals(homePage.getLastnameText(),
//                newUser.getLastname());
//        Assert.assertEquals(homePage.getRoleText(),
//                newUser.getRole());
        AssertWrapper.get()
                .forElement(homePage.getFirstname())
                    .valueMatch(newUser.getFirstname())
                    .valueStartsWith(newUser.getFirstname().substring(0,1))
                    .next()
                .forElement(homePage.getLastname())
                    .valueMatch(newUser.getLastname())
                    .next()
                .forElement(homePage.getRole().getText())
                    .valueMatch(newUser.getRole());
        // Test Operation
        administrationPage = homePage.logout()
                .successAdminLogin(UserRepository.get().getAdminUser())
                .gotoAdministration();
        Thread.sleep(4000);
        // Return to Previous State
        administrationPage.deleteByLoginName(newUser);
        Thread.sleep(4000);
        //
        // Singleton testing is Very Difficult !!!
        //
        // Mock
        //UserDao userDaoMock = Mockito.mock(UserDao.class);
        //Long id = UserDao.get().getUserDBByLogin(newUser.getLogin()).getId();
        //Mockito.stub(userDaoMock.deleteById(id)).toReturn(true);
        //
        // Reflection API
        //+++Field userDaoField = userService.getClass().getDeclaredField("userDao");
        //+++userDaoField.setAccessible(true);
        //+++userDaoField.set(userService, userDaoMock);
        //
        //UserService.get().deleteUsersByLogin(newUser.getLogin()); // Use Singleton, not Mock
        //
        UserService.get().deleteUsersByLogin(newUser.getLogin());
        System.out.println(UserService.get().getUserFirstnameByLogin(newUser.getLogin()));
        //
        // Preparation for Checking
        //Mockito.verify(userServiceMock).deleteUsersByPartialLogin(newUser.getLogin());
        //+++Mockito.verify(userDaoMock).deleteUsersByPartialLogin(newUser.getLogin());
        //
        // Save Actual Result. Preparation for Checking
//        AssertWrapper.get()
//                .forElement(administrationPage.getAlert())
//                .valueMatchInLastMessage(
//                        MessageRepository.AdministrationPageNotes.ALERT_DELETE_MESSAGE
//                                .toString());
        administrationPage.logout();
        // Checking
        AssertWrapper.get().check();
    }

}
