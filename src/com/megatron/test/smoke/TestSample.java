package com.megatron.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.megatron.lib.utils.TestConfiguration;

public class TestSample {
	WebDriver driver;
	
	@BeforeMethod
	public void precondition()
	{
		driver = TestConfiguration.getdriverinstance();
	}
	@Test
	public void testloginpagetitle()
	{
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		String Expectedtitle = "actiTIME - Login";
Assert.assertEquals(actualtitle, Expectedtitle);
		}
	@AfterMethod
	public void postcondition()
	{
		System.out.println("Thank you");
	}

	}


