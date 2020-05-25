package com.inetBanking.testCases;

import org.testng.annotations.Test;

import com.inetBanking.pagaObjects.LoginPage;
import com.inetBanking.pagaObjects.NewAccount;


public class TC_NewAccountTest_005 extends BaseClass{
	
	
	@Test
	public void NewAccount(String accountiD) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		NewAccount NewAcc=new NewAccount(driver);
		
		NewAcc.ClickNewAccount();
		
		logger.info("Providing New Account Details ..");
		
		NewAcc.newacccustomerid("71743");
		NewAcc.newaccacctype("Saving");
		NewAcc.newacccinitialdeposit("600");
		NewAcc.ClickNewAccount();
		logger.info("New Account Details Submitted");
	}
	
	

}
