package com.w2a.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.Base;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2q.utilities.Utilities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Login extends Base {
	LoginPage loginpage;

	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup() 
	{   
		
		driver=initializeBrowserAndOpenApplications(prop.getProperty("browser"));
		HomePage homepage= new HomePage(driver);
		homepage.clickOnMyAccount();
		LoginPage loginpage=homepage.SelectLoginOption();		
		
	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData()
	{
		//Object[][] data= {{ "amotooricap9@gmail.com","12345"},{"amotooricap3@gmail.com","12345"},{"amotooricap1@gmail.com","12345"}};
		
		Object[][] data= Utilities.getTestDataFromExcel("Login");
		return data;
		
	}
	
	
	
	@Test(priority=1, dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password)
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterEmailAddress(email);
		loginpage.enterpassword(password);
		loginpage.clickbutton();
				
		String actualwarningmessage=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		
		String expectedwarningmessage=dataProp.getProperty("emailpasswordNotmatch");
		Assert.assertTrue(actualwarningmessage.contains(expectedwarningmessage), "Expected warning message is not displayed");
		
	}
	
	@Test(priority=2)
	public void verifyLoginWithoutanyValidCredentials()
	{
		
		
		//driver.findElement(By.id("input-email")).sendKeys("amotoori3@gmail.com");
		//driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualwarningmessage=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		//div[@class='alert alert-danger alert-dismissible']
		String expectedwarningmessage=dataProp.getProperty("emailpasswordNotmatch");
		Assert.assertTrue(actualwarningmessage.contains(expectedwarningmessage), "Expected warning message is not displayed");
		
		
	}
	
	@Test(priority=3)
	public void verifyLoginWithoutInValidCredentials()
	{
		
		
		driver.findElement(By.id("input-email")).sendKeys("amotoori9@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("InvalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualwarningmessage=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		//div[@class='alert alert-danger alert-dismissible']
		String expectedwarningmessage=dataProp.getProperty("emailpasswordNotmatch");
		Assert.assertTrue(actualwarningmessage.contains(expectedwarningmessage), "Expected warning message is not displayed");
		
		
	}
	
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}

}
