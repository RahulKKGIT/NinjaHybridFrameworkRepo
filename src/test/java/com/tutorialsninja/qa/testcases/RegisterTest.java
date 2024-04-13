package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.Homepage;
import com.tutorialsninja.qa.pages.Registerpage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	

	public RegisterTest() {
		super();
	}
	public WebDriver driver;
	Registerpage registerPage;
	AccountSuccessPage AccountSuccessPage;
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@BeforeMethod
	public void setUp() {
		
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		Homepage homepage = new Homepage(driver);
		homepage.clickOnMyAccount();
		registerPage = homepage.selectRegisterOption();
		}
	
	@Test
	public void registerWithMandatoryFields() {
		
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephone(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword(dataProp.getProperty("validPassword"));
		registerPage.enterConfirmPassword(dataProp.getProperty("validPassword"));
		registerPage.selectPrivacyPolicy();
		AccountSuccessPage = registerPage.clickContinueButton();
		
		String actualMessage = AccountSuccessPage.retrieveAccountSuccessText();
		Assert.assertEquals(actualMessage, dataProp.getProperty("accountSuccessHeading"),"Success message is not displayed");
		
		
	}

}
