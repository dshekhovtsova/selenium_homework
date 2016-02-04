package com.nymgo.pages;

import org.openqa.selenium.WebDriver;

public abstract class NymgoPage {
	
	public WebDriver driver;
	


	public NymgoPage(WebDriver driver) {
		this.driver = driver;
	}
	

}
