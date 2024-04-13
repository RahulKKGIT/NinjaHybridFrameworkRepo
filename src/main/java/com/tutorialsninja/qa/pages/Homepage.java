package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name = "search")
	private WebElement searchBoxField;
	
	@FindBy(xpath = "//button[@class = 'btn btn-default btn-lg']")
	private WebElement searchButton;
	
	//constructor is created to avoid stale element reference exception
	//and to initialize the web elements each time the page is loaded
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	//Actions
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	
	}

	public Loginpage selectLoginOption() {
		loginOption.click();
		return new Loginpage(driver);
	}
	
	public Registerpage selectRegisterOption() {
		registerOption.click();
		return new Registerpage(driver);
}
	public void enterProduct(String productText) {
		searchBoxField.sendKeys(productText);
	}
	public Searchpage clickSearchButton() {
		searchButton.click();
		return new Searchpage(driver);
	}
}
