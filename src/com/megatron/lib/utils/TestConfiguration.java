package com.megatron.lib.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestConfiguration
	
	{
		public static WebDriver getdriverinstance()
		{
			String browser = DataHandlers.getDatafromProperties("config", "Browser");
			String URL = DataHandlers.getDatafromProperties("config", "test_URL");
			WebDriver driver = null;
			
			if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "./Browser-servers/geckodriver.exe");
				 driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./Browser-servers/chromedriver.exe");
				 driver = new ChromeDriver();
			}
			else{
				System.err.println("--------invalid browser option" + " Please check config.properties file");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(URL);
			return driver;
		}
	}
