package com.nymgo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends NymgoPage {
	public static final String BTN_SIGN_IN="//div[3]/ul/li[2]/a";
	public static final String BTN_JOIN_NOW="(//div[@class='sloganHolder']/a)[1]";
	
	
	public MainPage(WebDriver driver){
		super(driver);
	}
	
	public MainPage load(){
		driver.navigate().to("http://www.nymgo.com/");
		return new MainPage(driver);
	}
	
	public SignInPage clickBtnSignIn(){
		getBtnSignIn().click();
		return new SignInPage(driver);
	}
	
	public JoinNowPage clickBtnJoinNow(){
		getBtnJoinNow().click();
		return new JoinNowPage(driver);
	}
	
	public MainPage waitToBeAvailable(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(getBtnJoinNow()));
		wait.until(ExpectedConditions.elementToBeClickable(getBtnSignIn()));
		return new MainPage(driver);
	}
	
	public WebElement getBtnSignIn(){
		return driver.findElement(By.xpath(BTN_SIGN_IN));
	}
	
	public WebElement getBtnJoinNow(){
		return driver.findElement(By.xpath(BTN_JOIN_NOW));
	}
	
}
