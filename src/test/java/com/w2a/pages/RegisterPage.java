package com.w2a.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
WebDriver driver;
	
@FindBy(id="input-firstname")
private WebElement firstnamefield;

@FindBy(id="input-lastname")
private WebElement lastnamefield;

@FindBy(id="input-email")
private WebElement emailfield;

@FindBy(id="input-telephone")
private WebElement telephonefield;

@FindBy(id="input-password")
private WebElement passwordfield;

@FindBy(id="input-confirm")
private WebElement confirmpasswordfield;

@FindBy(id="agree")
private WebElement agreefield;

@FindBy(xpath="//input[@value='Continue']")
private WebElement continuebtn;


public RegisterPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);

}

public void enterFirstName(String firstnametext)
{
	firstnamefield.sendKeys(firstnametext);

}

public void enterlastName(String lastnametext)
{
	lastnamefield.sendKeys(lastnametext);

}

public void enterEmail(String emailtext)
{
	emailfield.sendKeys(emailtext);

}

public void enterTelephone(String telephonetext)
{
	telephonefield.sendKeys(telephonetext);

}

public void enterPassword(String passwordtext)
{
	passwordfield.sendKeys(passwordtext);

}

public void enterConfirm(String confirmtext)
{
	confirmpasswordfield.sendKeys(confirmtext);

}

public void selectAgree()
{
	agreefield.click();

}

public void ButtonContinue()
{
	continuebtn.click();

}







}
