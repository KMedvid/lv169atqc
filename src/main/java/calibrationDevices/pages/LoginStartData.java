package calibrationDevices.pages;

import org.openqa.selenium.WebDriver;

import calibrationDevices.data.IUrls;

public class LoginStartData {
    private WebDriver driver;
    private IUrls urls;

    public LoginStartData(WebDriver driver, IUrls urls) {
        this.driver = driver;
        this.urls = urls;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public IUrls getUrls() {
        return urls;
    }

    public void setUrls(IUrls urls) {
        this.urls = urls;
    }

}
