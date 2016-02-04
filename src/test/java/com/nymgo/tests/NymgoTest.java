package com.nymgo.tests;


import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.Matchers.equalTo; 
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.nymgo.framework.DriverManager;
import com.nymgo.pages.JoinNowPage;
import com.nymgo.pages.MainPage;


public class NymgoTest {
	WebDriver driver;
	
	@BeforeSuite	
	public void setUp(){
	driver = DriverManager.getFireFoxDriver();
	}

	
	@Test
	public void testJoinNowPage(){
		JoinNowPage joinPage = new MainPage(driver).load().waitToBeAvailable().clickBtnJoinNow().registerAsWrongUser("Test_Full_name", "Test_user_name", "aaaaaa", "aaaaaa", "aaaa@mail.com", "qqwwewerer");
		MatcherAssert.assertThat("Email already exists", joinPage.getEmailError().getText(), equalTo("That Email already exists. Please choose another one?"));
		MatcherAssert.assertThat("Incorrect mobile phone format", joinPage.getMobileError().getText(), equalTo("Mobile is invalid pattern"));
		MatcherAssert.assertThat("All fields are mandatory", joinPage.getNotificationMessage().getText(), equalTo("All fields are mandatory"));
		
	}
	
	@AfterSuite
	public void shutDown(){
		DriverManager.killDriver();
	}

}
