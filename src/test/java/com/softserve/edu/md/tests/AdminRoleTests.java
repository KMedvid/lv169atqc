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

import com.softserve.edu.atqc.data.StartData;
import com.softserve.edu.md.data.AgreementRepository;
import com.softserve.edu.md.data.IAgreement;
import com.softserve.edu.md.data.StartPage;
import com.softserve.edu.md.data.UserRepository;
import com.softserve.edu.md.pages.AgreementsPage;

public class AdminRoleTests {
    SoftAssert softAssert;
    public static final Logger logger = LoggerFactory.getLogger(AdminRoleTests.class);
    

    @BeforeClass
    public void oneTimeSetUp() {
        softAssert = new SoftAssert();
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
                { AgreementRepository.get().getProviderAgreementCold()},
                { AgreementRepository.get().getLaboratoryAgreementHeated()} };
    }

 
    @Test(dataProvider = "newAgreements")
    public void checkAddingNewAgreement(IAgreement agreement) {
        logger.info("TEST START: checkAddingNewAgreement");
        // PreCondition
        AgreementsPage agreementsPage = StartPage.get().load().gotoSignIn()
                .successAdminLogin(UserRepository.get().getAdminUser()).gotoAgreements();

        // Test Operation
        logger.info("TEST: addAgreement");
        agreementsPage.addAgreement(agreement);

        logger.info("TEST: initFirstTableRow");
        agreementsPage.initFirstTableRow();

        logger.info("TEST: clickDeleteAgreement");
        agreementsPage.clickDeleteAgreement();

        logger.info("TEST: Assert.assertEquals");
        Assert.assertEquals(agreementsPage.getCustomerText(), agreement.getCustomerName());

        logger.info("TEST DONE: checkAddingNewAgreement");

    }
}
