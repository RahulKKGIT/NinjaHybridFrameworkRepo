package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver driver;
	@FindBy(id="input-email")
	WebElement emailAddresField;
	
	@FindBy(id="input-password")
	WebElement passWordField;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	WebElement warningMessage;
	public Loginpage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailAddress(String emailText) {
		emailAddresField.sendKeys();
	}
	
	public void enterPassword(String passwordText) {
		passWordField.sendKeys();
	}
	
	public Accountpage clickLogin() {
		loginButton.click();
		return new Accountpage(driver);
	}
	
	public String getWarningMessageText() {
		String warningText = warningMessage.getText();
		return warningText;
	}
}



