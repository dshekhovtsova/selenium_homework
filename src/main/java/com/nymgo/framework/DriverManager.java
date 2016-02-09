package com.nymgo.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	private static WebDriver driver;
	
	public static WebDriver getFireFoxDriver(){
		if(driver == null)
		driver = new FirefoxDriver();
		
		return driver;
	}
	
	public static WebDriver getChromeDriver(){
		if(driver == null)
		driver = new ChromeDriver();
		
		return driver;
	}
	
	public static void killDriver(){
		driver.quit();
	}
	
	
}
