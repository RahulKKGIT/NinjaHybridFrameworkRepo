package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstNameField;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastNameField;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephoneField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement passwordConfirmField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	public Registerpage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String firstNameText) {
		
		firstNameField.sendKeys(firstNameText);
	}
	public void enterLastName(String lastNameText) {
		
		lastNameField.sendKeys(lastNameText);
	}
	public void enterEmail(String emailText) {
		
		emailField.sendKeys(emailText);
		
	}
	public void enterTelephone(String telephoneText) {
		
		telephoneField.sendKeys(telephoneText);
	}
	public void enterPassword(String passwordText) {
		
		passwordField.sendKeys(passwordText);
	}
	public void enterConfirmPassword(String confirmPasswordText) {
		
		passwordConfirmField.sendKeys(confirmPasswordText);
	}
	public void selectPrivacyPolicy() {
		
		privacyPolicyField.click();
	}
	public AccountSuccessPage clickContinueButton() {
		
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
}
