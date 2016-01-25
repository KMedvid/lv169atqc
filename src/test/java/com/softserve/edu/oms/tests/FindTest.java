package com.softserve.edu.oms.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import com.softserve.edu.atqc.data.StartData;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.StartPage;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.AdministrationPage.AdministrationPageConditions;
import com.softserve.edu.oms.pages.AdministrationPage.AdministrationPageFields;

public final class FindTest {
    StartData startData = new StartData("","","","chrome","");

    @AfterMethod
    public void tearDown() {
        StartPage.get().logout();
    }

    @AfterClass
    public void oneTimeTearDown() {
        BrowserUtils.quitAll();
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

    /*
    @Test(dataProvider = "newUsers")
    public void checkNewUserCreate(IUser newUser) {
        // PreCondition
        CreateNewUserPage createNewUserPage = StartLoginPage.load(browser, url)
                .successAdminLogin(UserRepository.getAdminUser())
                .gotoAdministrationPage()
                .gotoCreateNewUserPage();
        // Test Operation
        AdministrationPage administrationPage = createNewUserPage
                .createNewUser(newUser);
        administrationPage.searchByLoginName(AdministrationPageFields.LOGIN_NAME,
                AdministrationPageConditions.EQUALS, newUser);
        // Save Actual Result. Preparation for Checking
        AssertWrapper.get()
                .forElement(administrationPage.getFirstname().getText())
                    .valueMatch(newUser.getFirstname())
                    .next()
                .forElement(administrationPage.getLogin().getText())
                    .valueMatch(newUser.getLogin());
        // Test Operation
        HomePage homePage = administrationPage.logout()
                .successLogin(newUser);
        // Save Actual Result. Preparation for Checking
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
                .successAdminLogin(UserRepository.getAdminUser())
                .gotoAdministrationPage();
        // Return to Previous State
        administrationPage.deleteByLoginName(newUser);
        UserService.get(DataSourceRepository.getJtdsMsSqlLocal())
            .deleteUsersByPartialLogin(newUser.getLogin());
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

*/
}
