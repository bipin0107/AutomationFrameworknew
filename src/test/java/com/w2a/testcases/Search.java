package com.w2a.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.w2a.base.Base;
import com.w2a.pages.HomePage;
import com.w2a.pages.SearchPage;

public class Search extends Base {

	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplications(prop.getProperty("browser"));

	}

	@Test(priority = 1)

	public void verifySearchWithValidProduct() {
		HomePage homepage = new HomePage(driver);
		homepage.enterProductintoSearchBoxField(dataProp.getProperty("ValidProduct"));
		homepage.Searchbuttonclick();
		
		SearchPage searchpage=new SearchPage(driver);
		
		Assert.assertTrue(searchpage.displayStatusofValidProduct(), "HP products is not displaying");

	}

	@Test(priority = 2)

	public void verifySearchWithInValidProduct() {

		HomePage homepage = new HomePage(driver);
		homepage.enterProductintoSearchBoxField(dataProp.getProperty("InValidProduct"));
		homepage.Searchbuttonclick();
		SearchPage searchpage=new SearchPage(driver);

		String actualInvalidProduct = searchpage.retrieveNoProductMessageText();
		Assert.assertEquals(actualInvalidProduct, dataProp.getProperty("NoProductInSearchResult"),"No product message in search result not displayed");

	}

	@Test(priority = 3)

	public void verifySearchWithoutanyProduct() {
		
		HomePage homepage = new HomePage(driver);		
		driver.findElement(By.name("search")).sendKeys(" ");
		homepage.Searchbuttonclick();
		SearchPage searchpage=new SearchPage(driver);
		String actualInvalidProduct = searchpage.retrieveNoProductMessageText();

		Assert.assertEquals(actualInvalidProduct, dataProp.getProperty("NoProductInSearchResult"),"No product message in search result not displayed");

	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
