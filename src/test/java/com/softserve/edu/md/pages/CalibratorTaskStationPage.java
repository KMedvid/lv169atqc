package com.softserve.edu.md.pages;

import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.TextField;


public class CalibratorTaskStationPage {
	public static final String NUMBER_OF = "11199";
	private CalibratorTaskStationPageUIMap controls;


	public class CalibratorTaskStationPageUIMap {
		public ITextField searchnumberfield;
	
	
	public CalibratorTaskStationPageUIMap()
	{
	 this.searchnumberfield = TextField.get().getByXpath("//th[4]/div/div/div/input");	
	}
	}
	public CalibratorTaskStationPage(){
		controls = new CalibratorTaskStationPageUIMap();
	}
	
	public ITextField getNumberField(){
		return this.controls.searchnumberfield;
	}
	
	public void searchbynumberfield(){
		getNumberField().sendKeys("");
	}
}
