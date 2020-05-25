package com.inetBanking.pagaObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewAccount {
	
	WebDriver ldriver;
	
	public NewAccount(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how =How.XPATH, using ="/html/body/div[3]/div/ul/li[5]/a")
	@CacheLookup
	WebElement LnkNewAccount;
	
	@FindBy(how =How.NAME, using ="cusid")
	@CacheLookup
	WebElement txtcustomerid;
	
	@FindBy(how =How.NAME, using ="selaccount")
	@CacheLookup
	WebElement dropaccounttype;
	
	@FindBy(how =How.NAME, using ="inideposit")
	@CacheLookup
	WebElement txtinitialdeposit;
	
	@FindBy(how =How.NAME, using ="button2")
	@CacheLookup
	WebElement btnsubmitnewaccount;
	
	public void ClickNewAccount()
	{
		LnkNewAccount.click();
	}
	
	public void newacccustomerid(String customerid)
	{
		txtcustomerid.sendKeys(customerid);
	}
	
	public void newaccacctype(String acctype)
	{
	//	dropaccounttype.findElement(By.linkText(acctype));
		dropaccounttype.click();
		
	}
	
	public void newacccinitialdeposit(String newdeposite)
	{
		txtinitialdeposit.sendKeys(newdeposite);

	}
	
	public void newacccsubmit()
	{
		btnsubmitnewaccount.click();
	}
	
	
}
