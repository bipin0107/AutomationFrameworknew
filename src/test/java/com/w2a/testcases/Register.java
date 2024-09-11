package com.w2a.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.w2a.base.Base;
import com.w2a.pages.AccountSuccessPage;
import com.w2a.pages.HomePage;
import com.w2a.pages.RegisterPage;
import com.w2q.utilities.Utilities;

public class Register extends Base{

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;
	
	
	@BeforeMethod
	public void setup()
	{
		driver=initializeBrowserAndOpenApplications(prop.getProperty("browser"));
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.SelectRegisterOption();
				
	}

	@Test(priority = 1)

	public void verifyRegisteringAnAccountWithMandatoryFields(String firstname,String lastname, String email, String telephone, String password, String confirm, String agree) {

		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.enterFirstName(firstname);
		registerpage.enterlastName(lastname);
		registerpage.enterEmail(email);
		registerpage.enterTelephone(telephone);
		registerpage.enterPassword(password);
		registerpage.enterTelephone(telephone);
		registerpage.selectAgree();
		registerpage.ButtonContinue();		
		
		AccountSuccessPage accountSuccessPage= new AccountSuccessPage(driver);
		//accountSuccessPage.retrieveAccountSuccessPageHeading();
		
		String actualsuccessheading = accountSuccessPage.retrieveAccountSuccessPageHeading();
		Assert.assertEquals(actualsuccessheading, "Your Account Has Been Created!","Account Success page not displayed");

		//driver.quit();

	}

	@Test(priority = 2)

	public void verifyRegisteringAnAccountWithALLFields(String firstname,String lastname, String email, String telephone, String password, String confirm, String agree) {

		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.enterFirstName(firstname);
		registerpage.enterlastName(lastname);
		registerpage.enterEmail(email);
		registerpage.enterTelephone(telephone);
		registerpage.enterPassword(password);
		registerpage.enterTelephone(telephone);
		registerpage.selectAgree();
		registerpage.ButtonContinue();		
		
		AccountSuccessPage accountSuccessPage= new AccountSuccessPage(driver);
		
		
		
		
		
		
		
		
		
		driver.findElement(By.id("input-firstname")).sendKeys("Ram");
		driver.findElement(By.id("input-lastname")).sendKeys("Shivaji");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimestamp());
		driver.findElement(By.id("input-telephone")).sendKeys("9800065412");
		driver.findElement(By.id("input-password")).sendKeys("Test@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String actualsuccessheading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(actualsuccessheading, "Your Account Has Been Created!",
				"Account Success page not displayed");

		//driver.quit();

	}

	@Test(priority = 3)

	public void verifyRegistrationwithExistingEmailId() {
		
		
		driver.findElement(By.id("input-firstname")).sendKeys("Ram");
		driver.findElement(By.id("input-lastname")).sendKeys("Shivaji");
		driver.findElement(By.id("input-email")).sendKeys("amotooricap9@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("9800065412");
		driver.findElement(By.id("input-password")).sendKeys("Test@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String actualsuccessheading = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(actualsuccessheading.contains(dataProp.getProperty("duplicateemailregistrations")));

		//driver.quit();

	}
	
	@Test(priority = 4)

	public void verifyRegistrationwithoutFillingAnydetails() {
		
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualwarningpolicy=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();		
		Assert.assertTrue(actualwarningpolicy.contains(dataProp.getProperty("warningpolicy")),"Policy warning message does not displayed.");
		
		
		String actualwarningfirstname=driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		Assert.assertEquals(actualwarningfirstname,dataProp.getProperty("firstnamewarning"),"First Name warning message is not displayed");
		
		String actualwarninglastname=driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		Assert.assertEquals(actualwarninglastname,dataProp.getProperty("lastnamewarning"),"Last Name warning message is not displayed");
		
		String actualwarningemail=driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
		Assert.assertEquals(actualwarningemail,dataProp.getProperty("emailaddresswarning"),"Email Address warning message is not displayed");
		
		String actualwarningTelephone =driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		Assert.assertEquals(actualwarningTelephone,dataProp.getProperty("telephonewarning"),"Telephone warning message is not displayed");
		
		String actualwarningPassword =driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		Assert.assertEquals(actualwarningPassword,dataProp.getProperty("passwordwarning"),"Password warning message is not displayed");
	
		
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}

}
