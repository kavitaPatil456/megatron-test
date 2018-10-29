package com.megatron.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	public void waitforloginpagetoload(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("loginPage  ext-chrome"))));
	}
	public WebElement getusernametextbox()
	{
		return driver.findElement(By.name("username"));
	}
	public WebElement getpasswordtextbox()
	{
		return driver.findElement(By.name("pwd"));
	}
	public WebElement getloginbutton()
	{
		return driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
	}
	public WebElement getloginErrormsgtext()
	{
		return driver.findElement(By.xpath("//span[ contains(text(), 'Username or Password')]"));
		
	}


}
