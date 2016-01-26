package calibrationDevices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProviderWorkerhomePage extends MainPage{
    
    WebElement providerMainPanel;
    public ProviderWorkerhomePage(WebDriver driver){
        super(driver);
        this.providerMainPanel=driver.findElement(By.cssSelector("span[translate*='MAIN_PANEL_PROVIDER']"));
    }
    
    public WebElement getProviderMainPanel() {
        return this.providerMainPanel;
    }
    
    public void clickProviderMainPanel() {
        this.providerMainPanel.click();
    }
    
    public ProviderMainPanelPage gotoProviderMainPanelPage() {
        clickProviderMainPanel();
        return new ProviderMainPanelPage(driver);
    }
}
