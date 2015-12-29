package com.softserve.edu.md.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.md.data.CombineProvider;
import com.softserve.edu.md.data.IUrls;
import com.softserve.edu.md.data.IUser;
import com.softserve.edu.md.data.UrlRepository;
import com.softserve.edu.md.data.UserRepository;
import com.softserve.edu.md.data.WaterType;
import com.softserve.edu.md.pages.LoginStartPage;
import com.softserve.edu.md.pages.MetersCategoryPage;

public class LoginTest {
    
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
    public Object[][] existAdmins() {
        return new Object[][] {
            { UserRepository.get().getAdminUser(), UrlRepository.get().getVmUrls()}, 
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

    @Test(dataProvider = "existAdmins")
    //@Test(dataProvider = "existUsersCVS")
    //@Test(dataProvider = "existUsersExcel")
    public void checkLoginAdminUser(IUser admin, IUrls urls) {
        System.out.println("checkLoginAdminUser - START");
        // PreCondition
//        AdminHomePage adminHomePage = LoginStartPage.get().load(urls).gotoSignIn()
//                .successAdminLogin(UserRepository.get().getAdminUser());

        MetersCategoryPage metersCategoryPage = LoginStartPage.get().load(urls).gotoSignIn()
                .successAdminLogin(UserRepository.get().getAdminUser()).gotoMetersCategory();
        
        // Test Operation
        //metersCategoryPage.setSelectWaterTypeField(WaterType.COLD);
        metersCategoryPage.addNewMeterCategory(WaterType.HEATED, "Новий лічильник гарячої води");
        metersCategoryPage.initFirstTableRow();
        Assert.assertEquals(metersCategoryPage.getMeterNameText(), "Новий лічильник гарячої води");
//        metersCategoryPage.searchMeterCategory(WaterType.HEATED, "Новий лічильник гарячої води");
//        metersCategoryPage.deleteMeterCategory(WaterType.HEATED, "Новий лічильник гарячої води");
        //adminHomePage.gotoAgreements();
        //adminHomePage.gotoMetersType();
        //adminHomePage.gotoOrganizations();
        //adminHomePage.gotoAdminHome();
        
        // TODO Save Actual Result. Preparation for Checking
        // Checking
//        Assert.assertEquals(adminHomePage.getTitleText(), "Централізована система повірки лічильників");
        //Assert.assertEquals(administrationPage.getLastnameText(), existUser.getLastname());
        // Return to Previous State
        //administrationPage.gotoLogout();
        System.out.println("@Test: ThreadId = " + Thread.currentThread().getId());
        // LoginStartPage.quit();
        // TODO Checking
    }
}
