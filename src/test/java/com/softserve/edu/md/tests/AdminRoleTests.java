package com.softserve.edu.md.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.md.data.AgreementRepository;
import com.softserve.edu.md.data.IAgreement;
import com.softserve.edu.md.data.IUrls;
import com.softserve.edu.md.data.IUser;
import com.softserve.edu.md.data.UrlRepository;
import com.softserve.edu.md.data.UserRepository;
import com.softserve.edu.md.data.WaterType;
import com.softserve.edu.md.pages.AgreementsPage;
import com.softserve.edu.md.pages.LoginStartPage;
import com.softserve.edu.md.pages.MetersCategoryPage;

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

    @DataProvider
    public Object[][] newAreements() {
        return new Object[][] {
            { AgreementRepository.get().getProviderAgreementCold(), UrlRepository.get().getVmUrls()}
            };
    }
    

    @Test(dataProvider = "existAdmins")
    public void checkAddingNewMeterCategory(IUser admin, IUrls urls) {
        final String CATEGORY_NAME = "Новий лічильник гарячої води";
        final WaterType CATEGORY_WATER_TYPE = WaterType.HEATED;
        
        
        // PreCondition
        MetersCategoryPage metersCategoryPage = LoginStartPage.get().load(urls).gotoSignIn()
                .successAdminLogin(UserRepository.get().getAdminUser()).gotoMetersCategory();
        
        // Test Operation
        metersCategoryPage.addNewMeterCategory(CATEGORY_WATER_TYPE, CATEGORY_NAME);
        metersCategoryPage.initFirstTableRow();
        metersCategoryPage.clickDeleteMeterCategory();
        
        //Checking
        Assert.assertEquals(metersCategoryPage.getMeterNameText(), CATEGORY_NAME);
    }
    
    
    @Test(dataProvider = "existAdmins")
    public void checkAddingNewMeterCategoryFilterSearch(IUser admin, IUrls urls) {
        final String CATEGORY_NAME = "Новий лічильник холодної води";
        final WaterType CATEGORY_WATER_TYPE = WaterType.COLD;
        
        // PreCondition
        MetersCategoryPage metersCategoryPage = LoginStartPage.get().load(urls).gotoSignIn()
                .successAdminLogin(UserRepository.get().getAdminUser()).gotoMetersCategory();
        
        // Test Operation
        metersCategoryPage.addNewMeterCategory(CATEGORY_WATER_TYPE, CATEGORY_NAME);
        metersCategoryPage.initFirstTableRow();
        metersCategoryPage.deleteMeterCategory(CATEGORY_WATER_TYPE, CATEGORY_NAME); 
        Assert.assertEquals(metersCategoryPage.getMeterNameText(), CATEGORY_NAME);
    }
    
    //@Test(dataProvider = "newAreements")
    public void checkAddingNewMAgreement(IAgreement agreement, IUrls urls) {
        
        // PreCondition
        AgreementsPage agreementPage = LoginStartPage.get().load(urls).gotoSignIn()
                .successAdminLogin(UserRepository.get().getAdminUser()).gotoAgreements();
        
                // Test Operation
        agreementPage.clickAddAgreement();
//        Assert.assertEquals(metersCategoryPage.getMeterNameText(), CATEGORY_NAME);
    }
}
