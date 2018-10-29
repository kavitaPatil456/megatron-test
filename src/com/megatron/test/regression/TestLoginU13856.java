package com.megatron.test.regression;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.megatron.lib.ui.LoginPage;
import com.megatron.lib.utils.DataHandlers;
import com.megatron.lib.utils.TestConfiguration;

public class TestLoginU13856 {
	
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void precondition()
	{
		driver = TestConfiguration.getdriverinstance();
		login = new LoginPage(driver);
	}
	
	@Test
	public void testlogininvalidTC156786()
	{
		String un = DataHandlers.getDataFromExcel("tdata", "TC156786", 1, 0);
		String pw = DataHandlers.getDataFromExcel("tdata", "TC156786", 1, 1);
		//login.waitforloginpagetoload();
		login.getusernametextbox().sendKeys(un);
		login.getpasswordtextbox().sendKeys(pw);
		login.getloginbutton().click();
		String actualerrormsg = login.getloginErrormsgtext().getText();
		String expectederrormsg = DataHandlers.getDataFromExcel("tdata", "TC156786", 1, 2);
		Assert.assertEquals(actualerrormsg, expectederrormsg);	
	}
	@AfterMethod
	public void postcondition()
	{
		System.out.println("Thank you");
		driver.close();
	}
}
