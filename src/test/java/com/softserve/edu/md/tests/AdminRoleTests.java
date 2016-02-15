package com.softserve.edu.md.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.StartData;
import com.softserve.edu.atqc.loggers.LoggerUtils;
import com.softserve.edu.atqc.specs.AssertWrapper;
import com.softserve.edu.md.data.AgreementRepository;
import com.softserve.edu.md.data.IAgreement;
import com.softserve.edu.md.data.StartPage;
import com.softserve.edu.md.data.UserRepository;
import com.softserve.edu.md.pages.AgreementsPage;

public class AdminRoleTests {

//    SoftAssert softAssert;
    
    @BeforeClass
    public void oneTimeSetUp() {
//        softAssert = new SoftAssert();

        StartPage.get().load(new StartData(
                "http://10.1.10.100:8080/#/start"
                ,"http://10.1.10.100:8080/#/logout"
                ,""
                ,"firefox"
                ,""));
    }

    @AfterMethod
    public void tearDown() {
        StartPage.get().logout();
    }

    @AfterClass
    public void oneTimeTearDown() {
        StartPage.get().quit();
    }

    @DataProvider
    public Object[][] existAdmins() {
        return new Object[][] { { UserRepository.get().getAdminUser()} };
    }

    @DataProvider
    public Object[][] newAgreements() {
        return new Object[][] {
                { AgreementRepository.get().getProviderCalibratorAgreementCold()},
                { AgreementRepository.get().getCalibratorVerificatorAgreementCold()} };
    }

 
    @Test(dataProvider = "newAgreements")
    public void checkAddingNewAgreement(IAgreement agreement) {
        LoggerUtils.get()
            .infoLog("TEST START: checkAddingNewAgreement("+agreement.getAgreementCode()+")");
       
        // PreCondition
        AgreementsPage agreementsPage = StartPage.get().load().gotoSignIn()
                .successAdminLogin(UserRepository.get().getAdminUser()).gotoAgreements();

        // Test Operation
        LoggerUtils.get().infoLog("TEST: Add agreement");
        agreementsPage.addAgreement(agreement);

        LoggerUtils.get().infoLog("TEST: Update result table first row");        
        agreementsPage.initFirstTableRow();

        LoggerUtils.get().infoLog("TEST: Assert agreement");        
        AssertWrapper.get()
            .forElement(agreementsPage.getCustomerText())
            .valueMatch(agreement.getCustomerName())
            .next()
            .forElement(agreementsPage.getAgreementCodeText())
            .valueMatch(agreement.getAgreementCode())
            .next()
            .forElement(agreementsPage.getWaterType().getText())
            .valueMatch(agreement.getWaterType().toString());

        LoggerUtils.get().infoLog("TEST: Delete agreement");
        agreementsPage.clickDeleteAgreement();

        LoggerUtils.get().infoLog("TEST: Assert All");
        AssertWrapper.get().check();    

        LoggerUtils.get().infoLog("TEST DONE: checkAddingNewAgreement");

    }
}
