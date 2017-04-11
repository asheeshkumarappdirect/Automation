package com.AppDirect.BrowserSelect;

import java.util.Scanner;

import org.testng.Reporter;

public class BrowserChoice {

	public String BrowserSelection() {
		Reporter.log("Selecting browser", false);
		Reporter.log("Enter your choice", true);
		Reporter.log("1.Chrome", true);
		Reporter.log("2.Firefox", true);
		
		int choice;
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
		
		if(choice == 1) {
			return "Chrome";
		}
		else {
			return "Firefox";
		}		
	}
}