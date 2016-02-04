package com.nymgo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends NymgoPage {
	
	public static final String INPUT_USERNAME = "//*[@id='username-el']";
	public static final String INPUT_PASSWORD = "//*[@id='Password-el']";
	public static final String BTN_SIGN_IN = "//*[@id='user-login-el']";
	public static final String USERNAME_ERROR = ".//div[@id='username']//div[@class='validation-msg']";
	public static final String PASSWORD_ERROR = ".//div[@id='Password']//div[@class='validation-msg']";
	
	public SignInPage(WebDriver driver){
		super(driver);
	}
	
	public WebElement getInputUsername(){
		return driver.findElement(By.xpath(INPUT_USERNAME));
	}
	
	public WebElement getInputPassword(){
		return driver.findElement(By.xpath(INPUT_PASSWORD));
	}
	
	public WebElement getBtnSignIn(){
		return driver.findElement(By.xpath(BTN_SIGN_IN));
	}
	
	public WebElement getUsernameError(){
		return driver.findElement(By.xpath(USERNAME_ERROR));
	}
	
	public WebElement getPasswordError(){
		return driver.findElement(By.xpath(PASSWORD_ERROR));
	}
	public SignInPage loginAsWrongUser(String username, String password){
	getInputUsername().sendKeys(username);
	getInputPassword().sendKeys(password);
	clickBtnSignIn();
	return new SignInPage(driver);
 
	}
	
	
	private void clickBtnSignIn(){
		getBtnSignIn().click();
	}
	

}
