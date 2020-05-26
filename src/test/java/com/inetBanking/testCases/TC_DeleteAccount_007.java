package com.inetBanking.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pagaObjects.LoginPage;
import com.inetBanking.pagaObjects.DeleteAccount;


public class TC_DeleteAccount_007 extends BaseClass 
{
	
	@Test
	public void DeleteAccount() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username provided to DeleteAccount TC");
		lp.setPassword(password);
		logger.info("Password provided to DeleteAccount TC");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		DeleteAccount delacc=new DeleteAccount(driver);
		
		delacc.LnkDelAccount();
		delacc.DelAccountno("54654646");
		logger.info("Account no provided");
		delacc.DelSubmitBtn();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.info("Do you really want to delete this account");
			
			if(isAlertPresent()==true)
			{
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				logger.info("Account Does not Exist");
			}
			else
			{
				logger.warn("Not Authorised to delete the account");
			}
		}
		else
		{
			logger.warn("Unable to delete the account");
		}
		
	}

}
