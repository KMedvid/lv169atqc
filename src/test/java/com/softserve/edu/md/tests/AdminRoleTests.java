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
import com.softserve.edu.md.pages.LoginStartPage;
import com.softserve.edu.md.pages.MetersCategoryPage;
import com.softserve.edu.md.pages.MetersCategoryPage.WaterType;

public class AdminRoleTests {
    
    @AfterMethod
    public void tearDown() {
//        System.out.println("@AfterMethod: ThreadId = " + Thread.currentThread().getId());
        LoginStartPage.get().logout();
    }

    @AfterClass
    public void oneTimeTearDown() {
//        System.out.println("@AfterClass: ThreadId = " + Thread.currentThread().getId());
        LoginStartPage.get().quit();
    }

    @DataProvider
    public Object[][] existAdmins() {
        return new Object[][] {
            { UserRepository.get().getAdminUser(), UrlRepository.get().getVmUrls()}
            };
    }

    @Test(dataProvider = "existAdmins")
    public void checkAddingNewMeterCategory(IUser admin, IUrls urls) {
        final String CATEGORY_NAME = "Новий лічильник гарячої води";
        
        // PreCondition
        MetersCategoryPage metersCategoryPage = LoginStartPage.get().load(urls).gotoSignIn()
                .successAdminLogin(UserRepository.get().getAdminUser()).gotoMetersCategory();
        
        // Test Operation
        metersCategoryPage.addNewMeterCategory(WaterType.HEATED, CATEGORY_NAME);
        metersCategoryPage.initFirstTableRow();
        Assert.assertEquals(metersCategoryPage.getMeterNameText(), CATEGORY_NAME);
    }
    
    
    @Test(dataProvider = "existAdmins")
    public void checkAddingNewMeterCategory2(IUser admin, IUrls urls) {
        final String CATEGORY_NAME = "Новий лічильник гарячої води";
        
        // PreCondition
        MetersCategoryPage metersCategoryPage = LoginStartPage.get().load(urls).gotoSignIn()
                .successAdminLogin(UserRepository.get().getAdminUser()).gotoMetersCategory();
        
        // Test Operation
        metersCategoryPage.addNewMeterCategory(WaterType.HEATED, CATEGORY_NAME);
        metersCategoryPage.initFirstTableRow();
        Assert.assertEquals(metersCategoryPage.getMeterNameText(), CATEGORY_NAME);
    }
    
}
