package com.softserve.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
    public static final Logger logger = LoggerFactory.getLogger(AppTest.class);
    
    @Test
    public void testApp() {
        logger.info("testApp() - START");
        System.out.println("***AppTest: testApp() done");
        System.out.println("***Path="
                + this.getClass().getResource("/users.csv").getPath().substring(1));
        Assert.assertTrue(true);
        logger.info("testApp() - DONE");
    }

}
