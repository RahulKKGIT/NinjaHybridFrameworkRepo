package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.Homepage;
import com.tutorialsninja.qa.pages.Searchpage;

public class SearchTest extends Base {
	

	public SearchTest() {
		super();
	}
	public WebDriver driver;
	Searchpage searchpage;
	
	@BeforeMethod
	public void setup() {
	
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test (priority = 1)
	public void verifySearchWithValidProduct() {
		
		Homepage homepage = new Homepage(driver);
		homepage.enterProduct(dataProp.getProperty("validProduct"));
		searchpage = homepage.clickSearchButton();

		Assert.assertTrue(searchpage.displayStatusOfHPproduct(),"Valid product is not displayed");
	}
	
	@Test (priority = 2)
	public void verifySearchWithInvalidProduct() {
		
		Homepage homepage = new Homepage(driver);
		homepage.enterProduct(dataProp.getProperty("invalidProduct"));
		homepage.clickSearchButton();

		Searchpage searchpage = new Searchpage(driver);
		String actualSearchMessage = searchpage.retrieveNoProductMessageText();
		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("noProductText"));
		
	}
	@Test (priority = 3)
	public void verifySearchWithoutAnyProduct() {
		
		Homepage homepage = new Homepage(driver);
		homepage.clickSearchButton();
		
		Searchpage searchpage = new Searchpage(driver);
		String actualSearchMessage = searchpage.retrieveNoProductMessageText();
		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("noProductText"));
	}
	
}
