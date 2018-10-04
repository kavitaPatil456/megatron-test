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
		String Expectedtitle = "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com";
Assert.assertEquals(actualtitle, Expectedtitle);
		}
	@AfterMethod
	public void postcondition()
	{
		System.out.println("Thank you");
	}

	}


