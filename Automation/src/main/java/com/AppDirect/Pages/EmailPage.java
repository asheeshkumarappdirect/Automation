package com.AppDirect.Pages;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.AppDirect.Utils.ReadFile;

public class EmailPage {
	
	WebDriver driver;
	String inputxpath, buttonxpath, email;
	
	public EmailPage(WebDriver driver) {
		this.driver = driver;
	}

	public void EmailPageFuntionalities() throws IOException {
		Reporter.log("Email page", false);
		ReadFile read = new ReadFile();
		Properties pr = read.propertyFile("EmailPage.properties");
		inputxpath = pr.getProperty("inputxpath");
		buttonxpath= pr.getProperty("buttonxpath");
		
		Email();
	}
	
	public void Email() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);  
		String emailId = "username"+ randomInt +"@gmail.com";
		
		driver.findElement(By.xpath(inputxpath)).sendKeys(emailId);
		driver.findElement(By.xpath(buttonxpath)).click();
	}
}
