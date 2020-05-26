package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import com.inetBanking.pagaObjects.LoginPage;
import com.inetBanking.pagaObjects.EditCustomer;;

public class TC_EditCustomer_004 extends BaseClass{

	//Edit Customer
	
	@Test
		public void EditCustomer() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username is Provided for EditCustomerTest");
		lp.setPassword(password);
		logger.info("Password is Provided for EditCustomerTest");
		lp.clickSubmit();
		
		EditCustomer editcust=new EditCustomer(driver);
		editcust.LnkEditCustomer();
		logger.info("Clicked on EditCustomerTest");
		editcust.EditCustomerid("717435464");
		editcust.EditSubmitBtn();
		
		Thread.sleep(3000);
		
		
		
		
		if(isAlertPresent()==true)
		{
			String alertmessage=driver.switchTo().alert().getText();
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			{
			if(alertmessage=="Customer does not exist!!")
			{
			Assert.assertTrue(true);
			logger.warn("Unable to Edit the customer");
			}
			else
			{
				logger.warn("Customer Exist");
			}
			}
		}
		else
		{
			Assert.assertTrue(false);
			logger.warn("Customer details Edited");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
		}		
		
	}
		
	
}
