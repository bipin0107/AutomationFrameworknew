package com.w2a.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Objects
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText="Login")
	private WebElement loginoption;
	
	
	@FindBy(linkText="Register")
	private WebElement registeroption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//div[@id='search']/descendant:: button")
	private WebElement searchButton;

	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void clickOnMyAccount()
	{
		myAccountDropMenu.click();
		
	}
	
	public LoginPage SelectLoginOption()
	{
		loginoption.click();	
		return new LoginPage(driver);
	}
	
	public void SelectRegisterOption()
	{
		registeroption.click();	
	}

	public void enterProductintoSearchBoxField(String productText)
	{
		searchBoxField.sendKeys(productText);
		
	}
	
	public void Searchbuttonclick()
	{
		searchButton.click();	
	}
	
	

	
}
