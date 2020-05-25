package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pagaObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(user);
		logger.info("Username Provided");
		lp.setPassword(pwd);
		logger.info("Password Provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.warn("Login Passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
		}
				
	}
	
	public boolean isAlertPresent()	//user defined method to check alert is present on not
	{	try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[] [] getData() throws IOException
	{
		String path= System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "sheet1");
		int colcount=XLUtils.getCellCount(path, "sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for (int j=0; j<colcount; j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j); //1 ,0
			}
		}
	return logindata;
	}

}