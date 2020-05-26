package com.inetBanking.pagaObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer {

	WebDriver ldriver;

	public EditCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[3]/a")
	WebElement LnkEditCust;
	

	
	@FindBy(how=How.NAME, using="cusid")
	WebElement editcustid;
	
	@FindBy(how =How.NAME, using="AccSubmit")
	WebElement editbtnsubmit;
	
	public void LnkEditCustomer()
	{
		LnkEditCust.click();
	}
	
	public void EditCustomerid(String editcid)
	{
		editcustid.sendKeys(editcid);
	}
	
	public void EditSubmitBtn()
	{
		editbtnsubmit.click();
	}
	
	
}
