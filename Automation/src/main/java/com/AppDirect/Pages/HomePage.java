package com.AppDirect.Pages;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.AppDirect.Utils.ReadFile;
import com.AppDirect.exceptions.FileNotFoundException;

public class HomePage {
	String url, xpath;
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void HomePageFuntionalities() throws IOException, FileNotFoundException {
		
		Reporter.log("HomePage", false);
		ReadFile read = new ReadFile();
		Properties pr = read.propertyFile("HomePage.properties");
		url=pr.getProperty("url");
		xpath=pr.getProperty("xpath");
		driver.get(url);	

		logIn();
	}
	
	public void logIn() {
		driver.findElement(By.xpath(xpath)).click();;
	}
}
