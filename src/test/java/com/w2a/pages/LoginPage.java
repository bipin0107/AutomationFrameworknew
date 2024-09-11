package com.w2a.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	@FindBy(id="input-email")
	private WebElement emailfield;
	
	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	@FindBy(xpath="//input[@value='Login")
	private WebElement loginbuttonfield;
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Action
	public void enterEmailAddress(String emailText)
	{
		emailfield.sendKeys(emailText);
	}
	
	public void enterpassword(String passwordText)
	{
		emailfield.sendKeys(passwordText);
	}
	
	public void clickbutton()
	{
		loginbuttonfield.click();
	}
	

}
