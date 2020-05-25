package com.inetBanking.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pagaObjects.AddCustomerPage;
import com.inetBanking.pagaObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	
	@Test
	public void addnewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.ClickAddNewCustomer();
		
		logger.info("Providing Customer Details ..");
		
		addcust.custName("Sudarshan");
		addcust.custgender("male");
		addcust.custdob("10","12","1991");
		Thread.sleep(3000);
		addcust.custAddress("Chinchwad");
		addcust.custcity("Pune");
		addcust.custstate("Maharashtra");
		addcust.custpinno("411033");
		addcust.custtelephoneno("9028040507");
		
		String email=randomString()+ "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("Sudd@123");
		
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation started ..");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully !!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test case passed");
		}
		else
		{
			captureScreen(driver, "AddNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test case failed");
		}
		
	}

}