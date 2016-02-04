package com.nymgo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JoinNowPage extends NymgoPage {
	
	
	public static final String INPUT_FULLNAME = "//input[@id='full_name-el']";
	public static final String INPUT_USERNAME = "//input[@id='Username-Email-el']";
	public static final String INPUT_PASSWORD = "//input[contains(@id, 'Password-el') and (@title='Password')]";
	public static final String INPUT_CONFIRM_PASSWORD = "//input[contains(@id, 'Password-el') and (@title='Confirm Password')]";
	public static final String INPUT_EMAIL = "//input[@id='Email-el']";
	public static final String INPUT_MOBILE = "//input[@id='mobile-el']";
	public static final String NOTIFICATION_MESSAGE = "//div[@class='all-fields-mendatory']";
	public static final String BTN_JOIN = "//input[@id='send-btn-el']";
	public static final String MOBILE_ERROR = ".//div[@id='mobile']//div[@class='validation-msg']";
	public static final String EMAIL_ERROR = ".//div[@id='Email']//div[@class='validation-msg']";
	

	public JoinNowPage(WebDriver driver){
		super(driver);
	}
	
	public WebElement getInputFullName(){
		return driver.findElement(By.xpath(INPUT_FULLNAME));
	}
	
	public WebElement getInputUsername(){
		return driver.findElement(By.xpath(INPUT_USERNAME));
	}
	public WebElement getInputPassword(){
		return driver.findElement(By.xpath(INPUT_PASSWORD));
	}
	public WebElement getInputConfirmPassword(){
		return driver.findElement(By.xpath(INPUT_CONFIRM_PASSWORD));
	}
	public WebElement getInputEmail(){
		return driver.findElement(By.xpath(INPUT_EMAIL));
	}
	public WebElement getInputMobile(){
		return driver.findElement(By.xpath(INPUT_MOBILE));
	}
	public WebElement getNotificationMessage(){
		return driver.findElement(By.xpath(NOTIFICATION_MESSAGE));
	}
	public WebElement getButtonJoin(){
		return driver.findElement(By.xpath(BTN_JOIN));
	}
	public WebElement getMobileError(){
		return driver.findElement(By.xpath(MOBILE_ERROR));
	}
	public WebElement getEmailError(){
		return driver.findElement(By.xpath(EMAIL_ERROR));
	}
	
	public JoinNowPage registerAsWrongUser(String fullname, String username, String password, String confirmPassword, String email, String mobile){
		getInputFullName().sendKeys(fullname);
		getInputUsername().sendKeys(username);
		getInputPassword().sendKeys(password);
		getInputConfirmPassword().sendKeys(confirmPassword);
		getInputEmail().sendKeys(email);
		getInputMobile().sendKeys(mobile);
		clickBtnJoin();
		return new JoinNowPage(driver);
	 
		}
		
		
		private void clickBtnJoin(){
			getButtonJoin().click();
		}
	
	
}
