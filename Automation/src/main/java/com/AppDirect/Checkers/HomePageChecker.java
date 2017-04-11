package com.AppDirect.Checkers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.AppDirect.Pages.HomePage;

public class HomePageChecker {
	public void CheckHomePage(WebDriver driver) {
		
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("AppDirect"));
		
	}
}
