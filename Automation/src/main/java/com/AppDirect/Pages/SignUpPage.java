package com.AppDirect.Pages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.AppDirect.Utils.ReadFile;
import com.AppDirect.exceptions.FileNotFoundException;

public class SignUpPage {
	WebDriver driver;
	String xpath;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void SignUpPageFuntionalities() throws IOException, FileNotFoundException {
		
		Reporter.log("SignUpPage", false);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		ReadFile read = new ReadFile();
		Properties pr = read.propertyFile("SignUp.properties");
		xpath = pr.getProperty("xpath");
		
		signUp();
	}
	
	public void signUp() {
		driver.findElement(By.xpath(xpath)).click();
	}
}
