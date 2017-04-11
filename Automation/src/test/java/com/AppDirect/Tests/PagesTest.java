package com.AppDirect.Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.AppDirect.BrowserSelect.BrowserChoice;
import com.AppDirect.BrowserSelect.BrowserDriver;
import com.AppDirect.Pages.EmailPage;
import com.AppDirect.Pages.HomePage;
import com.AppDirect.Pages.SignUpPage;
import com.AppDirect.exceptions.FileNotFoundException;
import com.AppDirect.Checkers.BrowserChecker;
import com.AppDirect.Checkers.EmailPageChecker;
import com.AppDirect.Checkers.HomePageChecker;
import com.AppDirect.Checkers.SignUpPageChecker;

import junit.framework.Assert;

public class PagesTest{
	
	WebDriver driver;
	String browser;
	
	@BeforeClass
	public void StartBrowser() {
		Reporter.log("Testing while starting browser", false);
				
//		browser contains name of browser chosen by the user
		BrowserChoice choice = PageFactory.initElements(driver, BrowserChoice.class);
		browser = choice.BrowserSelection();
		
//		driver contains the driver of browser chosen by the user
		BrowserDriver browserDriver = PageFactory.initElements(driver, BrowserDriver.class);
		driver = browserDriver.driver(browser);
		
		driver.manage().window().maximize();
		
		BrowserChecker browserChecker = PageFactory.initElements(driver, BrowserChecker.class);
		browserChecker.CheckBrowser(browserDriver);
	}
	
	@Test
	public void HomePageTest() throws IOException, FileNotFoundException {		
		Reporter.log("Testing homepage", true);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.HomePageFuntionalities();	
		
//		HomePageChecker homePageChecker = PageFactory.initElements(driver, HomePageChecker.class);
//		homePageChecker.CheckHomePage(homePage);
		
		HomePageChecker homePageChecker = PageFactory.initElements(driver, HomePageChecker.class);
		homePageChecker.CheckHomePage(driver);
		
	}
	
	
	@Test(dependsOnMethods = {"HomePageTest"})
	public void SignUpPageTest() throws IOException, FileNotFoundException {
		Reporter.log("Testing SignUpPage", true);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		signUpPage.SignUpPageFuntionalities();
		
		SignUpPageChecker signUpPageChecker = PageFactory.initElements(driver, SignUpPageChecker.class);
		signUpPageChecker.CheckSignUp(driver);
		
	}
	
	@Test(dependsOnMethods = {"SignUpPageTest"})
	public void EmailPage() throws IOException {
		Reporter.log("Testing EmailPage", true);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		EmailPage emailPage = PageFactory.initElements(driver, EmailPage.class);
		emailPage.EmailPageFuntionalities();
		
		EmailPageChecker emailPageChecker = PageFactory.initElements(driver, EmailPageChecker.class);
		emailPageChecker.CheckEmail(driver);
		
	}
	
	@AfterClass
	public void CloseBrowser() throws InterruptedException {
		Reporter.log("Closing the browser");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(2000);		
		
		driver.quit();
	}
	
}
