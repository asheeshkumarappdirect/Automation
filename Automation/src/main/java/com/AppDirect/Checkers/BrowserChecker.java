package com.AppDirect.Checkers;

import org.testng.Reporter;

import com.AppDirect.BrowserSelect.BrowserDriver;

public class BrowserChecker {
	public void  CheckBrowser(BrowserDriver browserDriver) {
		
		if(browserDriver == null) {
			throw new NullPointerException("Browser not found");
		}
		else {
			Reporter.log("Browser found!");
		}
	}
}
