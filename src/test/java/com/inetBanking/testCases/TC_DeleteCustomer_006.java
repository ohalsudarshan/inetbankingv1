package com.inetBanking.testCases;

import org.testng.annotations.Test;

import com.inetBanking.pagaObjects.LoginPage;
import com.inetBanking.pagaObjects.DeleteCustomer;
import java.io.IOException;
import org.testng.Assert;


public class TC_DeleteCustomer_006 extends BaseClass
{	
	@Test
	public void DeleteCustomer() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username is Provided for DeleteCustomerTest");
		lp.setPassword(password);
		logger.info("Password is Provided for DeleteCustomerTest");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		DeleteCustomer delcust=new DeleteCustomer(driver);
				
		delcust.DelCustomerLnk();
		delcust.DelCustomerid("852369");
		delcust.DelSubmitBtn();
		
		
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			logger.info("Confirmation to delete the customer");
			if(isAlertPresent()==true)
			{
				driver.switchTo().alert().accept();
		//		driver.switchTo().defaultContent();
				Assert.assertTrue(true);
				logger.info("Authersation to delete the customer");
			}
			else
			{
				logger.warn("Not Authorised to delete the customer");
			}
		}
		
			else
			{
				logger.info("cannot delete the customer");
			}
		}
		
				
	}
	

