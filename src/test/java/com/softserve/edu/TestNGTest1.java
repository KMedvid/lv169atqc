package com.softserve.edu;

import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGTest1 {

    // @BeforeClass
    public void oneTimeSetUp(ITestContext context) {
        System.out.println("@BeforeClass - oneTimeSetUp");
        // Map<String, String> testParams =
        // context.getCurrentXmlTest().getLocalParameters();
        System.out.println("\nSuite" + context.getCurrentXmlTest().getSuite().getParameters());
        System.out.println("\nTest" + context.getCurrentXmlTest().getLocalParameters());

        // for (String testParams.values()) {
        // startData.getBrowser().quit();
        // }
    }

    // @AfterClass
    public void oneTimeTearDown() {
        // one-time cleanup code
        System.out.println("@AfterClass - oneTimeTearDown");
    }

    // @BeforeMethod
    public void setUp(ITestContext context) {
        System.out.println("@BeforeMethod - setUp");
        System.out.print("\nSuite ");
        System.out.println(context.getCurrentXmlTest().getSuite().getParameters());
        System.out.print("\nTest ");
        System.out.println(context.getCurrentXmlTest().getLocalParameters());
    }

    // @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod - tearDown");
    }

    @DataProvider
    public Object[][] provider(ITestContext context) {
        Map<String, String> suiteParams = context.getCurrentXmlTest().getSuite().getParameters();
        Map<String, String> testParams = context.getCurrentXmlTest().getLocalParameters();
        System.out.println("\n\t@DataProvider suiteParams = " + suiteParams);
        System.out.println("\n\t@DataProvider testParams = " + testParams);
        //
        HashMap<String, String> hashMap = new HashMap<String, String>(suiteParams);
        for (String key : hashMap.keySet()) {
            System.out.println("\t\t*** key = " + key + "  value = " + hashMap.get(key));
        }
        //
        return new Object[][] { { suiteParams.get("paramSuite") }, { testParams.get("paramTest") }, };
    }

    @Test(dataProvider = "provider")
    public void testEmptyCollection(String param) {
        System.out.println("\n@Test - testEmptyCollection");
        System.out.println("Param = " + param);
    }

}
