package calibrationDevices.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import calibrationDevices.data.IUser;

public class LoginPage {
	private WebDriver driver;
	
	private WebElement login;
	private WebElement password;
	private WebElement submit;
	private WebElement startPage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 30)).until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[ng-model='loginForm.username']")));
		
		this.login = driver.findElement(By.cssSelector("[ng-model='loginForm.username']"));
		this.password = driver.findElement(By.id("inputPassword"));
		this.submit = driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary.btn-block.withoutBorder.ng-binding"));
		this.startPage = driver.findElement(By.cssSelector("[href*='start']"));
	}

	// Get Elements
	public WebElement getLogin() {
		return this.login;
	}

	public WebElement getPassword() {
		return this.password;
	}

	public WebElement getSubmit() {
		return this.submit;
	}
	

    public WebElement getStartPage() {
        return this.startPage;
    }

	public String getLoginText() {
		return this.login.getText();
	}

	public String getPasswordText() {
		return this.password.getText();
	}

	// Set Data
	public void setLogin(String login) {
		this.login.sendKeys(login);
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clearLogin() {
		this.login.clear();
	}

	public void clearPassword() {
		this.password.clear();
	}

	public void clickLogin() {
		this.login.click();
	}

	public void clickPassword() {
		this.password.click();
	}

	public void clickSubmit() {
		this.submit.click();
	}
	
	public void clickStartPage() {
	    this.startPage.click();
	}

	// Business Logic
	private void setLoginData(IUser user) {
		clickLogin();
		clearLogin();
		setLogin(user.getLogin());
		clickPassword();
		clearPassword();
		setPassword(user.getPassword());
		clickSubmit();
	}

	public ProviderHomePage successProviderLogin(IUser provider) {
		setLoginData(provider);
		return new ProviderHomePage(driver);
	}

	public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
		setLoginData(invalidUser);
		return new LoginValidatorPage(driver);
	}
	
	public ProviderWorkerhomePage successProviderWorkerLogin(IUser providerWorker) {
	    setLoginData(providerWorker);
	    return new ProviderWorkerhomePage(driver);
	    
	}
	
    public StartPageMD gotoStartPage() {
        clickStartPage();
        return new StartPageMD(driver);
    }
}