package com.softserve.edu;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

    @Test
    public void testApp() {
        System.out.println("***AppTest: testApp() done");
        System.out.println("***Path="
                + this.getClass().getResource("/users.csv").getPath().substring(1));
        Assert.assertTrue(true);
    }

}
