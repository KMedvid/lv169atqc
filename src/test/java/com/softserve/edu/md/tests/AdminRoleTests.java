package com.softserve.edu.md.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
import com.softserve.training.Calc;

public class AdminRoleTests {
    SoftAssert softAssert;
    public static final Logger logger = LoggerFactory.getLogger(Calc.class);
    
    @BeforeClass
    public void oneTimeSetUp() {
        softAssert = new SoftAssert();  
        
    }
    
    @AfterMethod
    public void tearDown() {
        LoginStartPage.get().logout();
    }

    @AfterClass
    public void oneTimeTearDown() {
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
        logger.info("TEST START: checkAddingNewMeterCategory");
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
        logger.info("TEST DONE: checkAddingNewMeterCategory");

    }
    
    
    @Test(dataProvider = "existAdmins")
    public void checkAddingNewMeterCategoryFilterSearch(IUser admin, IUrls urls) {
        final String CATEGORY_NAME = "Новий лічильник холодної води";
        final WaterType CATEGORY_WATER_TYPE = WaterType.COLD;

        logger.info("TEST START: checkAddingNewMeterCategoryFilterSearch");

        
        // PreCondition
        MetersCategoryPage metersCategoryPage = LoginStartPage.get().load(urls).gotoSignIn()
                .successAdminLogin(UserRepository.get().getAdminUser()).gotoMetersCategory();
        
        // Test Operation
        metersCategoryPage.addNewMeterCategory(CATEGORY_WATER_TYPE, CATEGORY_NAME);
        metersCategoryPage.initFirstTableRow();
        softAssert.assertEquals(metersCategoryPage.getMeterNameText(), CATEGORY_NAME);

        metersCategoryPage.deleteMeterCategory(CATEGORY_WATER_TYPE, CATEGORY_NAME); 
        softAssert.assertEquals(metersCategoryPage.getMeterNameText(), CATEGORY_NAME);
        
        softAssert.assertAll();
        logger.info("TEST DONE: checkAddingNewMeterCategoryFilterSearch");

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
