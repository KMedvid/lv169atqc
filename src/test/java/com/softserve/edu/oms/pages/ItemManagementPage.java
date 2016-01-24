package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.Link;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.atqc.tools.ControlLocation;
import com.softserve.edu.atqc.tools.ControlSearch;

public class ItemManagementPage {

	public static enum ItemManagementPageFields {
		PRODUCT_NAME("Product Name"), 
		DESCRIPTION("Description");
		
		private String field;

		private ItemManagementPageFields(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}

	private class ItemManagementPageUIMap {
		public final ILink addProduct;
		// public final ISelect selectField;
		public final ITextField searchField;
		public final ILink logout;

		public ItemManagementPageUIMap() {
			this.addProduct = Link.get().getByPartialLinkText("Add Product");
			this.searchField = TextField.get().getById("searchField");
			// this.field = Select.getById("field");
			this.logout = Link.get().getByXpath("//a[@href='/OMS/logout.htm']");
		}
	}

	private class ItemManagementPageTableUIMap {
        public final ILabel productsFound;
        public final ILabel name;
        public final ILabel description;
        public final ILabel price;
        public final ILink edit;
        public final ILink delete;
        public final String  productsFoundText;

        public ItemManagementPageTableUIMap() {
            // TODO if Load Table Complete
            this.productsFound = Label.get().getById("recordsFound");
            this.productsFoundText = productsFound.getText();
            
            if (Integer.parseInt(productsFoundText) > 0) {
                this.name = Label.get().getByXpath("//tbody/tr[1]/td[1]");
                this.description = Label.get().getByXpath("//tbody/tr[1]/td[2]");
                this.price = Label.get().getByXpath("//tbody/tr[1]/td[3]");
                this.edit = Link.get().getByXpath("//tbody/tr[1]/td[4]/a");
                this.delete = Link.get().getByXpath("//tbody/tr[1]/td[5]/a");
            } else {
                this.name = Label.get().getByXpath("//tbody/tr[1]/th[1]");
                this.description = Label.get().getByXpath("//tbody/tr[1]/th[2]");
                this.price = Label.get().getByXpath("//tbody/tr[1]/th[3]");
                this.edit = Link.get().getByXpath("//tbody/tr[1]/th[4]");
                this.delete = Link.get().getByXpath("//tbody/tr[1]/th[5]");
            }
        }
        
        public ItemManagementPageTableUIMap(String productName) {
            // TODO if Load Table Complete
            // TODO Check Existing Row
            this.productsFound = Label.get().getById("recordsFound");
            this.productsFoundText = productsFound.getText();
            //
            this.name = Label.get().getByXpath("//tbody/tr[1][text()='" + productName + "']");
            this.description = Label.get().getByXpath("//tbody/tr[1][text()='" + productName + "']/following-sibling::td[2]");
            this.price = Link.get().getByXpath("//tbody/tr[1][text()='" + productName + "']/following-sibling::td[3]");
            this.edit = Link.get().getByXpath("//tbody/tr[1][text()='" + productName + "']/following-sibling::td[4]/a");
            this.delete = Link.get().getByXpath("//tbody/tr[1][text()='" + productName + "']/following-sibling::td[5]/a");
        }
	}

 
	// Elements
    private ItemManagementPageUIMap controls;
    // AJAX Elements
    private ItemManagementPageTableUIMap controlsTable;
    // Alert Elements
    //private IAlertLight controlsAlert = null;

	
    public ItemManagementPage() {
        controls = new ItemManagementPageUIMap();
        controlsTable = new ItemManagementPageTableUIMap();
    }


    // Get Elements
    // Set Data
    // Business Logic

    private boolean isTableRefresh() {
        return this.controlsTable.name.isStatelessOf()
                && this.controlsTable.productsFound.isInvisibleWithText(
                        this.controlsTable.productsFoundText);
    }
    
    // getters controls
    public ILink getAddProduct() {
        return this.controls.addProduct;
    }

//    public ISelect getSelectField() {
//        return this.controls.selectField;
//    }


    public ITextField getSearchField() {
        return this.controls.searchField;
    }

    public ILink getLogout() {
        return this.controls.logout;
    }
    
    public String getSearchFieldText() {
        return this.controls.searchField.getText();
    }
    
    public final ILabel productsFound;
    public final ILabel name;
    public final ILabel description;
    public final ILabel price;
    public final ILink edit;
    public final ILink delete;
    public final String  productsFoundText;
    
    // getters controlsTable
    public ILabel getProductsFound() {
        return this.controlsTable.productsFound;
    }

    public ILabel getName() {
        return this.controlsTable.name;
    }

    public ILabel getDescription() {
        return this.controlsTable.description;
    }

    public ILabel getPrice() {
        return this.controlsTable.price;
    }

    public ILink getEdit() {
        return this.controlsTable.edit;
    }
    
    public ILink getDelete() {
        return this.controlsTable.delete;
    }
    
    public String getNameText() {
        return this.controlsTable.name.getText();
    }

    public String getDescriptionText() {
        return this.controlsTable.description.getText();
    }

    public String getPriceText() {
        return this.controlsTable.price.getText();
    }
    
 // setters controls

    public void setSelectField(ItemManagementPageFields field) {
        //this.controls.selectField.selectByVisibleText(field.toString());
        // TODO +++
        ControlSearch.get().getVisibleSelectWebElement(ControlLocation.getById("field"))
            .selectByVisibleText(field.toString());
    }
    
    public void setSearchField(String text) {
        this.controls.searchField.sendKeys(text);
    }

    public void clearSearchField() {
        this.controls.searchField.clear();
    }

    public void clickSearchField() {
        this.controls.searchField.click();
    }

    public void clickAddProduct() {
        this.controls.addProduct.click();
    }

    public void clickLogout() {
        this.controls.logout.click();
    }
    
 // setters controlsTable

    public void resetTable() {
        if (isTableRefresh()) {
            controlsTable = new ItemManagementPageTableUIMap();
        }
    }
    
    public void resetTable(String productName) {
        if (isTableRefresh()) {
            controlsTable = new ItemManagementPageTableUIMap(productName);
        }
    }
    
    public void acceptAlert() {
//      if (this.controlsAlert != null) {
//      this.controlsAlert.click();
//      this.controlsAlert = null;
//        controls = new ItemManagementPageUIMap();
//        controlsAjax = newItemManagementPageUIMapAjax();
          //
//        resetTable();
//  }
        // TODO +++
       BrowserUtils.get().getBrowser().getWebDriver().switchTo().alert().dismiss();
    }

    public void dismissAlert() {
//      if (this.controlsAlert != null) {
//          this.controlsAlert.click();
//          this.controlsAlert = null;
//      }
    } 
    
 // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void searchProductByName(String productName){
        setSelectField(ItemManagementPageFields.PRODUCT_NAME);
        setSearchField(productName);
        // Initialize Table Elements
        resetTable(productName);
    }
    
    public AddProductPage gotoAddProduct() {
        clickAddProduct();
        return new AddProductPage();
    }

    public LoginPage logout() {
        clickLogout();
        return new LoginPage();
    }
    
}
