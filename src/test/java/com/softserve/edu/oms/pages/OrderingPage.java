package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.Link;
import com.softserve.edu.atqc.controls.TextField;

public class OrderingPage {
	
	 public static enum OrderingPageFields {
	        ORDER_NAME("orderName"),
	        STATUS("Status"),
	        ASSIGNEE("assignee");
	        private String field;

	        private OrderingPageFields(String field) {
	            this.field = field;
	        }

	        @Override
	        public String toString() {
	            return this.field;
	        }
	    }
	 
	 private class OrderingPageUIMap {
	        public final ITextField searchField;
	        public final ILink logout;
	        public final IButton apply;

	        public OrderingPageUIMap() {
	            this.searchField = TextField.get().getById("searchField");
	            this.logout = Link.get().getByXpath("//a[@href='/OMS/logout.htm']");
	            this.apply = Button.get().getByXpath("//input[@value='Apply']");
	        }
	    }
	 
	private class OrderingPageTableUIMap {
		//TODO
	}

	 
    public OrderingPage() {
    }

}
