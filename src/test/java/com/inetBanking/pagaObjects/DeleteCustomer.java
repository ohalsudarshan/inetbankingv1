package com.inetBanking.pagaObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class DeleteCustomer {

	WebDriver ldriver;
	

	public DeleteCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how =How.XPATH, using="/html/body/div[3]/div/ul/li[4]/a")
	WebElement lnkdeletcustomer;
	
	@FindBy(how=How.NAME, using="cusid")
	WebElement delcustid;
	
	@FindBy(how =How.NAME, using="AccSubmit")
	WebElement delbtnsubmit;
	
	
	public void DelCustomerLnk()
	{
		lnkdeletcustomer.click();
	}
	
	public void DelCustomerid(String dlcid)
	{
		delcustid.sendKeys(dlcid);
	}
	
	public void DelSubmitBtn()
	{
		delbtnsubmit.click();
	}
	
	
}
