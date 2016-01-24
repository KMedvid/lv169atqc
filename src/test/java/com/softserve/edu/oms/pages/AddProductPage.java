package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.Link;
import com.softserve.edu.atqc.controls.TextField;

public class AddProductPage {

	private class AddProductPageUIMap {
	    public ILink logout;
		public ITextField productName;
		public ITextField productDescription;
		public ITextField productPrice;
		public IButton submit;
		public IButton cancel;
		
		public AddProductPageUIMap() {
			this.logout = Link.get().getByXpath("//a[@href='/OMS/logout.htm']");
			this.productName = TextField.get().getById("name");
			this.productDescription = TextField.get().getById("description");
			this.productPrice = TextField.get().getById("price");			

			this.submit = Button.get().getByXpath("//input[@value='OK']");
			this.cancel = Button.get().getByXpath("//input[@value='Cancel']");
		}

	}
	
	 // Elements
    private AddProductPageUIMap controls;
    
    public AddProductPage() {
        this.controls = new AddProductPageUIMap();
        //controlsAlertLight = AlertLight.getWithScreen();
    }
    
    
    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public void setProductName(String productName) {
		this.controls.productName.sendKeys(productName);
	}

	public void setProductDescription(String productDescription) {
		this.controls.productDescription.sendKeys(productDescription);
	}

	public void setProductPrice(Double productPrice) {
		this.controls.productPrice.sendKeys(productPrice.toString());
	}

	public void clickSubmit() {
		this.controls.submit.click();
	}

	public void clickCancel() {
		this.controls.cancel.click();
	}
	
	public void clickProductName() {
		this.controls.productName.click();
	}

	public void clickProductDescription() {
		this.controls.productDescription.click();
	}

	public void clickProductPrice() {
		this.controls.productPrice.click();
	}
	
	public void clearProductName() {
		this.controls.productName.clear();
	}

	public void clearProductDescription() {
		this.controls.productDescription.clear();
	}

	public void clearProductPrice() {
		this.controls.productPrice.clear();
	}
	
	public void fillProductName(String name) {
		clickProductName();
		clearProductName();
		setProductName(name);
	}
	
	public void fillproductDescription(String name) {
		clickProductDescription();
		clearProductDescription();
		setProductDescription(name);
	}
	
	public void fillProductPrice(Double price) {
		clickProductPrice();
		clearProductPrice();
		setProductPrice(price);
	}
	
    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public ItemManagementPage addProduct(String productName, String productDescription, Double productPrice) {
    	fillProductName(productName);
    	fillproductDescription(productDescription);
    	fillProductPrice(productPrice);

    	clickSubmit();
    	
        return new ItemManagementPage();
    }

    public LoginPage logout() {
        controls.logout.click();
        // controlsAlertLight.alertAccept();
        return new LoginPage();
    }
}
