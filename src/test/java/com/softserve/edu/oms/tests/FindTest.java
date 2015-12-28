package com.softserve.edu.oms.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.oms.data.CombineProvider;
import com.softserve.edu.oms.data.IUrls;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UrlRepository;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.LoginStartPage;

public class FindTest {

    @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod: ThreadId = " + Thread.currentThread().getId());
        LoginStartPage.get().logout();
    }

    @AfterClass
    public void oneTimeTearDown() {
        System.out.println("@AfterClass: ThreadId = " + Thread.currentThread().getId());
        LoginStartPage.get().quit();
    }

    @DataProvider//(parallel = true)
    public Object[][] existUsers() {
        return new Object[][] {
            { UserRepository.get().getExistUser(), UrlRepository.get().getLocalUrls() },
            { UserRepository.get().getCustomerUser(), UrlRepository.get().getLocalUrls() },
            { UserRepository.get().getAdminUser(), UrlRepository.get().getSsuUrls() }, 
            };
    }

    @DataProvider//(parallel = true)
    public Object[][] existUsersCVS() {
        return  CombineProvider.get().getExistUsersCVS(UrlRepository.get().getLocalUrls());
    }

    @DataProvider//(parallel = true)
    public Object[][] existUsersExcel() {
        return  CombineProvider.get().getExistUsersExcel(UrlRepository.get().getLocalUrls());
    }

    //@Test(dataProvider = "existUsers")
    //@Test(dataProvider = "existUsersCVS")
    @Test(dataProvider = "existUsersExcel")
    public void checkExistUsersFind(IUser existUser, IUrls urls) {
        // PreCondition
        AdministrationPage administrationPage = LoginStartPage.get().load(urls)
                .successAdminLogin(UserRepository.get().getAdminUser()).gotoAdministration();
        // Test Operation
        administrationPage.searchByLoginName(existUser);
        // TODO Save Actual Result. Preparation for Checking
        // Checking
        // System.out.println("TEST: "+administrationPage.getFirstnameText());
        Assert.assertEquals(administrationPage.getFirstnameText(), existUser.getFirstname());
        Assert.assertEquals(administrationPage.getLastnameText(), existUser.getLastname());
        // Return to Previous State
        administrationPage.gotoLogout();
        System.out.println("@Test: ThreadId = " + Thread.currentThread().getId());
        // LoginStartPage.quit();
        // TODO Checking
    }

}
