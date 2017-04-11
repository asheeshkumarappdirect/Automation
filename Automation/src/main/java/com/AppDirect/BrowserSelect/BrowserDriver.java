package com.AppDirect.BrowserSelect;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.AppDirect.BrowserSelect.SupportedBrowser;

public class BrowserDriver {
	WebDriver driver;

	public WebDriver driver(String browser) {
		
		if(SupportedBrowser.CHROME.toString().equalsIgnoreCase(browser)) {
			Reporter.log("Selected ChromeBrowser", false);
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
		}
		
		else if(SupportedBrowser.FIREFOX.toString().equalsIgnoreCase(browser)) {
			Reporter.log("Selected FirefoxBrowser", false);
			System.setProperty("webdriver.gecko.driver","geckodriver");
			driver = new FirefoxDriver();
		}
		
		else {
			Reporter.log("Selected DefaultBrowser: Chrome", false);
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
		}
		
		return driver;
	}
}
