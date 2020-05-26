package com.inetBanking.pagaObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccount {
	
	WebDriver ldriver;
	public DeleteAccount(WebDriver rdriver)
	{
		rdriver=ldriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how =How.XPATH, using="/html/body/div[3]/div/ul/li[4]/a")
	@CacheLookup
	WebElement lnkdeletAcct;
	
	@FindBy(how=How.NAME, using="accountno")
	@CacheLookup
	WebElement delacctno;
	
	@FindBy(how =How.NAME, using="AccSubmit")
	@CacheLookup
	WebElement delacctbtnsubmit;
	
	
	public void LnkDelAccount()
	{
		lnkdeletAcct.click();
	}
	
	public void DelAccountno(String delaccno)
	{
		delacctno.sendKeys(delaccno);
	}
	
	public void DelSubmitBtn()
	{
		delacctbtnsubmit.click();
	}

}
