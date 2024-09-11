package com.w2a.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.w2q.utilities.Utilities;

public class Base {
	public Properties prop;
	public Properties dataProp;
	
	public Base()
	{
		prop=new Properties();
		File propFile=new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\w2a\\config\\config.properties");
		
		dataProp= new Properties();
		File datafile=new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\w2a\\testdata\\testdata.properties");
		try {
			FileInputStream fis2= new FileInputStream(datafile);
			dataProp.load(fis2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis= new FileInputStream(propFile);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	WebDriver driver;
	
	public WebDriver initializeBrowserAndOpenApplications(String browsername)
	{
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		else if(browsername.equalsIgnoreCase("safari"))
		{
			driver= new SafariDriver();
		}
			
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}

}
