package com.softserve.edu.md.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.md.data.IUrls;
import com.softserve.edu.md.data.IUser;
import com.softserve.edu.md.data.UrlRepository;
import com.softserve.edu.md.data.UserRepository;
import com.softserve.edu.md.pages.AdminHomePage;
import com.softserve.edu.md.pages.LoginStartPage;

public class LoginTest2 {
    
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

    @DataProvider
    public Object[][] existAdmins() {
        return new Object[][] {
            { UserRepository.get().getAdminUser(), UrlRepository.get().getVmUrls()}, 
            };
    }

    @Test(dataProvider = "existAdmins")
    public void checkLoginAdminUser(IUser admin, IUrls urls) {
        // PreCondition
        // Test Operation
        AdminHomePage adminHomePage = LoginStartPage.get().load(urls).gotoSignIn()
                .successAdminLogin(UserRepository.get().getAdminUser());
     
       // Checking
        Assert.assertEquals(adminHomePage.getTitleText(), "Централізована система повірки лічильників");
    }
}
