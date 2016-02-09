package com.nymgo.tests;


import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nymgo.framework.DriverManager;
import com.nymgo.pages.JoinNowPage;
import com.nymgo.pages.MainPage;


public class NymgoTest {
	WebDriver driver;
	
	@BeforeSuite (alwaysRun=true)	
	@Parameters({"browser"})
	//@Before Method - before each test
	public void setBrowser(String browserType){
		if(browserType.equals("firefox")){
			driver  = DriverManager.getFireFoxDriver();
		}
		else if (browserType.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "extra-libs/chromedriver.exe"); // path to the Chrome driver in our sources 
			driver  = DriverManager.getChromeDriver();
			
			
		}
		driver.manage().window().maximize();	

	}

	
	@Test(groups="test1")
	public void testEmailFiledOnJoinNowPage(){
		JoinNowPage joinPage = new MainPage(driver).load().waitToBeAvailable().clickBtnJoinNow().registerAsWrongUser("Test_full_name", "Test_user_name", "aaaaaa", "aaaaaa", "aaaa@mail.com", "+380630746076");
		MatcherAssert.assertThat("Email already exists", joinPage.getEmailError().getText(), equalTo("That Email already exists. Please choose another one?"));
		
		
	}
	@Test(groups="test1")
	public void testPhoneFiledOnJoinNowPage(){
		JoinNowPage joinPage = new MainPage(driver).load().waitToBeAvailable().clickBtnJoinNow().registerAsWrongUser("Test_full_name", "Test_user_name", "aaaaaa", "aaaaaa", "aaaa@mail.com", "qqwwewerer");	
		MatcherAssert.assertThat("Incorrect mobile phone format", joinPage.getMobileError().getText(), equalTo("Mobile is invalid pattern"));

		
	}
	@Test(groups = "test2")
	public void testMandatoryFiledsOnJoinNowPage(){
		JoinNowPage joinPage = new MainPage(driver).load().waitToBeAvailable().clickBtnJoinNow().registerAsWrongUser("Test_full_name", "Test_user_name", "aaaaaa", "aaaaaa", "aaaa@mail.com", "qqwwewerer");
		MatcherAssert.assertThat("All fields are mandatory", joinPage.getNotificationMessage().getText(), equalTo("All fields are mandatory"));
		
	}
	
	@AfterSuite(alwaysRun=true)
	public void shutDown(){
		DriverManager.killDriver();
	}

}
