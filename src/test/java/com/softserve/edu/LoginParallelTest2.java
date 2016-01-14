package com.softserve.edu;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.StartData;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UserRepository;

public class LoginParallelTest2 {
    StartData startData = new StartData("","","chrome","");

	@AfterClass
	public void oneTimeTearDown() {
	    BrowserUtils.quitAll();
	}

	@DataProvider//(parallel = true)
	public Object[][] allUsers() {
		return new Object[][] {
				{ UserRepository.get().getAdminUser() },
				{ UserRepository.get().getCustomerUser() }
				};
	}

	@Test(dataProvider = "allUsers")
	public void checkLogin(IUser user) throws InterruptedException {
		// Precondition
		System.out.println("\t***Running, Thread Id = "
				+ Thread.currentThread().getId() + "  User.login name = "
				+ user.getLogin());
//		if (Thread.currentThread().getId() == 11L) {
//		    System.out.println("+++Init Start Data");
//		    BrowserUtils.get(startData);
//		}
		// Test Operation
		BrowserUtils.get(startData);
		BrowserUtils.get().getBrowser().loadPage("http://ssu-oms:8180/OMS/login.htm");
		BrowserUtils.get().getBrowser().getWebDriver().findElement(By.name("j_username")).sendKeys(user.getLogin());
		BrowserUtils.get().getBrowser().getWebDriver().findElement(By.name("j_password")).sendKeys("qwerty");
		BrowserUtils.get().getBrowser().getWebDriver().findElement(By.name("submit")).click();
		Thread.sleep(4000);
		// Return
		BrowserUtils.get().getBrowser().loadPage("http://ssu-oms:8180/OMS/logout.htm");
		System.out.println("+++Logout");
		Thread.sleep(2000);
		startData.setBrowserName("firefox");
		//startData = new StartData("","","firefox","");
		// driver.quit();
	}

}
