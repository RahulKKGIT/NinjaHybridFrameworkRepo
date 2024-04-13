package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.Accountpage;
import com.tutorialsninja.qa.pages.Homepage;
import com.tutorialsninja.qa.pages.Loginpage;
import com.tutorialsninja.qa.utils.Utilities;



public class LoginTest extends Base{
	
		public LoginTest() {
			super();
		}
		
		Loginpage loginPage;
	
		public WebDriver driver;
		
		@AfterMethod
		public void tearDown() {
			
			driver.quit();
		}
		
		@BeforeMethod
		public void setUp() {
			
			driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
			Homepage homepage = new Homepage(driver);
			homepage.clickOnMyAccount();
			loginPage = homepage.selectLoginOption();
			}
		
	
	@Test(priority = 1, dataProvider = "validCredentialsSupplier")
	
	public void verifyLoginWithValidCredentials(String email, String Password) {
		
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(Password);
		Accountpage accountPage = loginPage.clickLogin();
		
		Assert.assertTrue(accountPage.getDisplayStatusofEditAccontInfo(),"Edit Your Account Information is not displayed");
		
		
			
	}
	@DataProvider(name = "validCredentialsSupplier")
	public Object[] [] supplyTestData() {
		
		Object[] [] data = Utilities.getTestDataFromExcel("Login");
		return data;
		
	}
	@Test(priority = 2)
	
	public void verifyLoginWithInvalidCredentials() {
		
		
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginpage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginpage.clickLogin();
		
		String actualWarningMessage = loginpage.getWarningMessageText();
		String expectedMsg = dataProp.getProperty("emailPassNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedMsg),"Expected warning msg is not displayed");
	
		
	}
	
	@Test(priority = 3)

	public void verifyLoginWithoutCredentials() {
		
		Loginpage loginpage = new Loginpage(driver);
		loginpage.clickLogin();
		
		String actualWarningMessage = loginpage.getWarningMessageText();
		String expectedMsg = dataProp.getProperty("emailPassNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedMsg),"Expected warning msg is not displayed");
		
		



	}
}
