package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import com.inetBanking.pagaObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException 
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered Username ");
		
		lp.setPassword(password);
		logger.info("Entered Username ");
		
		lp.clickSubmit();
		
				
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed ");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed ");
		}
	}
}
